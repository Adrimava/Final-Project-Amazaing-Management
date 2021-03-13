import { Component, Input, OnChanges, OnInit } from '@angular/core';
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
  }

  getCompanies(id: number): void {
    this.amazaingManagementService.getCompaniesByPlayerId(id).subscribe(result => {
      this.companyList = result;
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
    setTimeout(()=>{ this.getCompanies(this.currentPlayer); }, 200);
  }

  createCompany(): void {
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
    this.revenue = 0;
    this.maintenance = 0;
    this.employeesNumber = 0;
    this.accidentRiskIndex = 0;
    setTimeout(()=>{ this.getCompanies(this.currentPlayer); }, 200);
    this.formIsVisible = false;
  }

  updateCompany(id: number): void {
    let company: CompanyDTO = new CompanyDTO(
      this.companyName,
      this.revenue,
      this.maintenance,
      this.employeesNumber,
      this.accidentRiskIndex,
      this.selectedBusinessModel.modelId,
      this.currentPlayer
    );

    this.amazaingManagementService.updateCompany(id, this.body(company));
    setTimeout(()=>{ this.getCompanies(this.currentPlayer); }, 100);
    setTimeout(()=>{ this.company = this.companyList[this.companyList.length - 1] }, 200 ); 
  }

  deleteCompany(id: number): void {
    if (this.companyList.length > 1) {
      this.amazaingManagementService.deleteCompany(id);
      setTimeout(()=>{ this.getCompanies(this.currentPlayer); }, 100);
      setTimeout(()=>{ this.company = this.companyList[this.companyList.length - 1] }, 200 );
    }
  }

  body(company: CompanyDTO): any {
    let companyBody: any = {
      companyName: company.companyName,
      revenue: company.revenue,
      maintenance: company.maintenance,
      employeesNumber: company.employeesNumber,
      accidentRiskIndex: company.accidentRiskIndex,
      businessModel: company.businessModelId,
      player: company.playerId
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

}
