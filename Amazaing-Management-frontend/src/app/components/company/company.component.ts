import { Component, OnInit } from '@angular/core';
import { CompanyDTO } from 'src/app/models/company-dto';
import { AmazaingManagementService } from 'src/app/services/amazaing-management.service';
import { BusinessModel, Company } from 'src/app/services/interfaces/database.interface';

@Component({
  selector: 'app-company',
  templateUrl: './company.component.html',
  styleUrls: ['./company.component.css']
})
export class CompanyComponent implements OnInit {

  companyList: Company[] = [];
  company: Company = null;
  companyName: string = '';
  revenue: number = 0;
  maintenance: number = 0;
  employeesNumber: number = 0;
  accidentRiskIndex: number = 0;
  businessModelId: number = 0;
  playerId: number = 0;
  formIsVisible: boolean = false;
  businessModel: BusinessModel;

  constructor(
    private amazaingManagementService: AmazaingManagementService
  ) { }

  ngOnInit(): void {
    this.getCompanies();
    // this.businessModelDetails(1);
    this.companyDetails(1);
  }

  getCompanies(): void {
    this.amazaingManagementService.getAllCompanies().subscribe(result => {
      this.companyList = result;
    }, error => {
      console.log(error);
    });
  }

  companyDetails(id: number): void {
    this.amazaingManagementService.getCompanyById(id).subscribe(result => {
      this.company = result;
    });
    this.amazaingManagementService.getBusinessModelById(id).subscribe(result => {
      this.businessModel = result;
    });
    // this.businessModelDetails(this.company.businessModelId);
  }

  createCompany(): void {
    let company: CompanyDTO = new CompanyDTO(
      this.companyName,
      this.revenue,
      this.maintenance,
      this.employeesNumber,
      this.accidentRiskIndex,
      this.businessModelId,
      this.playerId
    );
    
    this.amazaingManagementService.storeCompany(this.body(company));
    this.companyName = '';
    this.revenue = 0;
    this.maintenance = 0;
    this.employeesNumber = 0;
    this.accidentRiskIndex = 0;
    this.businessModelId = 0;
    this.playerId = 0;
  }

  updateCompany(id: number): void {
    let company: CompanyDTO = new CompanyDTO(
      this.companyName,
      this.revenue,
      this.maintenance,
      this.employeesNumber,
      this.accidentRiskIndex,
      this.businessModelId,
      this.playerId
    );

    this.amazaingManagementService.updateCompany(id, this.body(company));
  }

  deleteCompany(id: number): void {
    this.amazaingManagementService.deleteCompany(id);
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

}
