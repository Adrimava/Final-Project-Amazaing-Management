import { Component, EventEmitter, Input, OnChanges, OnInit, Output } from '@angular/core';
import { CompanyDTO } from 'src/app/models/company-dto';
import { AmazaingManagementService } from 'src/app/services/amazaing-management.service';
import { BusinessModel, Company, Employee } from 'src/app/services/interfaces/database.interface';

@Component({
  selector: 'app-company',
  templateUrl: './company.component.html',
  styleUrls: ['./company.component.css']
})
export class CompanyComponent implements OnInit, OnChanges{

  @Input()
  currentPlayer: number = 1;
  @Input()
  firstCompany: number = 1;
  @Input()
  money: number = 1000;
  companyList: Company[] = [];
  company: Company = null;
  companyName: string = '';
  revenue: number = 0;
  maintenance: number = 0;
  employeesNumber: number = 0;
  accidentRiskIndex: number = 0;
  formIsVisible: boolean = false;
  businessModel: BusinessModel;
  employeeList: Employee[] = [];
  businessModelList: BusinessModel[] = [];
  selectedBusinessModel: BusinessModel;
  notEnoughMoney: boolean = false;
  totalWeeklyBalance: number = 0;

  @Output() sendMoneyChanges = new EventEmitter<number>();

  constructor(
    private amazaingManagementService: AmazaingManagementService
  ) { }

  ngOnInit(): void {
    this.getCompanies(this.currentPlayer);
    setTimeout(()=>{ this.businessModelDetails(this.companyList[0].businessModelId) }, 100);
    setTimeout(()=>{ this.companyDetails(this.companyList[0].companyId) }, 100);
    this.getBusinessModels();
    setTimeout(()=>{ this.selectBusinessModelDetails(this.businessModelList[0].modelId) }, 100);
    setTimeout(()=>{
      if (this.companyList.length === 0) {
        this.createFirstCompany(this.firstCompany);
      }
    }, 200);
  }

  ngOnChanges(): void {
    this.ngOnInit();
    this.update();
  }

  getCompanies(id: number): void {
    this.amazaingManagementService.getCompaniesByPlayerId(id).subscribe(result => {
      this.companyList = result;
      this.totalWeeklyBalance = 0;
      for (let company of this.companyList) {
        this.totalWeeklyBalance += company.revenue - company.maintenance;
      };
    }, error => {
      console.log(error);
    });
  }

  companyDetails(id: number): void {
    this.amazaingManagementService.getCompanyById(id).subscribe(result => {
      this.company = result;
      this.businessModelDetails(this.company.businessModelId);
      this.getEmployeesByCompany(id);
    });
    setTimeout(()=>{ this.company.employeesNumber = this.employeeList.length; }, 100);
  }

  showPannel(): void {
    this.formIsVisible = !this.formIsVisible;
    this.notEnoughMoney = false;
  }

  createFirstCompany(id: number): void {
    let company: CompanyDTO = new CompanyDTO(
      "My first Company",
      this.revenue,
      this.maintenance,
      this.employeesNumber,
      this.accidentRiskIndex,
      id,
      this.currentPlayer
    );
    
    this.amazaingManagementService.storeCompany(this.body(company));
    setTimeout(()=>{ this.getCompanies(this.currentPlayer); }, 100);
    setTimeout(()=>{ this.update(); }, 300);
  }

  createCompany(): void {
    if (this.money >= this.selectedBusinessModel.purchasePrice) {
      this.notEnoughMoney = false;
      this.sendMoneyChanges.emit(this.selectedBusinessModel.purchasePrice * -1);
      let company: CompanyDTO = new CompanyDTO(
        this.companyName,
        this.revenue,
        this.maintenance,
        this.employeesNumber,
        this.accidentRiskIndex,
        this.selectedBusinessModel.modelId,
        this.currentPlayer
      );      
      this.amazaingManagementService.storeCompany(this.body(company));
      this.companyName = '';
      setTimeout(()=>{ this.getCompanies(this.currentPlayer); }, 100);
      setTimeout(()=>{ this.update(); }, 300);
      this.formIsVisible = false;
    } else {
      this.notEnoughMoney = true;
    }
  }

  update() : void {
    this.getCompanies(this.currentPlayer);
    setTimeout(()=>{
      for (let company of this.companyList) {
        this.updateCompany(company);
      }
    }, 100);
    setTimeout(()=>{ this.getCompanies(this.currentPlayer); }, 500);
    this.totalWeeklyBalance = 0;
    for (let company of this.companyList) {
      this.totalWeeklyBalance += company.revenue - company.maintenance;
    }
  }

  updateCompany(updatedCompany: Company): void {
    updatedCompany.employeesNumber = updatedCompany.employees.length;
    updatedCompany.maintenance = (updatedCompany.businessModelDetails.dailyCosts +
      updatedCompany.businessModelDetails.employeeSalary * updatedCompany.employeesNumber);
    updatedCompany.revenue = 0;
    updatedCompany.accidentRiskIndex = 0;
    for (let employee of updatedCompany.employees) {
      updatedCompany.revenue += employee.productivity * updatedCompany.businessModelDetails.averageRevenue / 100;
      updatedCompany.accidentRiskIndex += employee.clumsiness;
    }
    if (updatedCompany.employees.length > 0) {
      updatedCompany.accidentRiskIndex /= updatedCompany.employees.length;
    }

    let company: CompanyDTO = new CompanyDTO(
      updatedCompany.companyName,
      updatedCompany.revenue,
      updatedCompany.maintenance,
      updatedCompany.employeesNumber,
      updatedCompany.accidentRiskIndex,
      updatedCompany.businessModelId,
      this.currentPlayer
    );

    setTimeout(()=>{ this.amazaingManagementService.updateCompany(updatedCompany.companyId, this.body(company)); }, 100);
  }

  deleteCompany(id: number): void {
    if (this.companyList.length > 1) {
      this.sendMoneyChanges.emit(this.businessModel.purchasePrice * 0.8);
      this.amazaingManagementService.deleteCompany(id);
      setTimeout(()=>{ this.getCompanies(this.currentPlayer); }, 100);
      setTimeout(()=>{ this.company = this.companyList[this.companyList.length - 1] }, 200 );
    }
    this.update();
  }

  body(company: CompanyDTO): any {
    let companyBody: any = {
      companyName: company.companyName,
      revenue: company.revenue,
      maintenance: company.maintenance,
      employeesNumber: company.employeesNumber,
      accidentRiskIndex: company.accidentRiskIndex,
      businessModelId: company.businessModelId,
      playerId: company.playerId
    }
    return companyBody;
  }

  businessModelDetails(id: number): void {
    this.amazaingManagementService.getBusinessModelById(id).subscribe(result => {
      this.businessModel = result;
    });
  }

  getEmployeesByCompany(id: number): void {
    this.amazaingManagementService.getEmployeesByCompanyId(id).subscribe(result => {
      this.employeeList = result;
    }, error => {
      console.log(error);
    });
  }

  getBusinessModels(): void {
    this.amazaingManagementService.getAllBusinessModel().subscribe(result => {
      this.businessModelList = result;
    }, error => {
      console.log(error);
    });
  }
  
  selectBusinessModelDetails(id: number): void {
    this.amazaingManagementService.getBusinessModelById(id).subscribe(result => {
      this.selectedBusinessModel = result;
    });
  }

  refresh(): void {
    this.sendMoneyChanges.emit(0);
  }

  nextWeek(): void {
    this.sendMoneyChanges.emit(this.totalWeeklyBalance);
  }

}
