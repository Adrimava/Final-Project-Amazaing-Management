import { Component, Input, OnChanges, OnInit } from '@angular/core';
import { EmployeeDTO } from 'src/app/models/employee-dto';
import { AmazaingManagementService } from 'src/app/services/amazaing-management.service';
import { Company, Employee } from 'src/app/services/interfaces/database.interface';

@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.css']
})
export class EmployeeComponent implements OnInit, OnChanges {

  @Input()
  currentPlayer: number = 1;
  @Input()
  money: number = 1000;
  employeeList: Employee[] = [];
  employee: Employee = null;
  employeeName: string = '';
  photo: string = '';
  productivity: number = 0;
  clumsiness: number = 0;
  companyId: number = 0;
  formIsVisible: boolean = false;
  company: Company = null;
  companyList: Company[] = [];
  selectedCompany: Company;

  constructor(
    private amazaingManagementService: AmazaingManagementService
  ) { }

  ngOnInit(): void {
    this.getEmployeesByPlayer(this.currentPlayer);
    setTimeout(()=>{ this.employeeDetails(this.employeeList[0].employeeId) }, 200);
    this.getCompanies(this.currentPlayer);
    setTimeout(()=>{ this.selectCompanyDetails(this.companyList[0].companyId) }, 200);
  }

  ngOnChanges(): void {
    this.ngOnInit();
  }

  getEmployeesByPlayer(id: number): void {
    this.amazaingManagementService.getEmployeesByPlayerId(id).subscribe(result => {
      this.employeeList = result;
    }, error => {
      console.log(error);
    });
  }

  employeeDetails(id: number): void {
    this.amazaingManagementService.getEmployeeById(id).subscribe(result => {
      this.employee = result;
    });
    setTimeout(()=>{ this.getEmployeesByPlayer(this.currentPlayer) }, 100);
    setTimeout(()=>{ this.companyDetails(this.employee.companyId) }, 100);
  }

  showPannel(): void {
    this.randomValues();
    this.formIsVisible = true;
  }

  randomValues(): void {
    this.amazaingManagementService.getRandomName().subscribe(result => {
      this.employeeName = result.results[0].name.first + ' ' + result.results[0].name.last;
      this.photo = 'https://avatars.dicebear.com/api/bottts/' + this.employeeName + '.svg'
    });
    this.productivity = this.randomNumber(100);
    this.clumsiness = this.randomNumber(50);
  }

  randomNumber(max: number): number {
    let num = max * Math.sin(Math.random() * (Math.PI / 2));
    return Math.round(num);
  }

  createEmployee(): void {
    let employee: EmployeeDTO = new EmployeeDTO(
      this.employeeName,
      this.photo + this.employeeName +".svg",
      this.productivity,
      this.clumsiness,
      this.companyId,
      this.currentPlayer
    );

    this.amazaingManagementService.storeEmployee(this.body(employee));
    this.randomValues();
    this.companyId = 0;
    setTimeout(()=>{ this.getEmployeesByPlayer(this.currentPlayer); }, 100);
    this.formIsVisible = false;
  }

  updateEmployee(id: number): void {
    let employee: EmployeeDTO = new EmployeeDTO(
      this.employee.employeeName,
      this.employee.photo,
      this.employee.productivity,
      this.employee.clumsiness,
      this.employee.companyId,
      this.currentPlayer
    );

    this.amazaingManagementService.updateEmployee(id, this.body(employee));
    setTimeout(()=>{ this.getEmployeesByPlayer(this.currentPlayer); }, 100);
    setTimeout(()=>{ this.employee = this.employeeList[this.employeeList.length - 1] }, 200 );
  }

  deleteEmployee(id: number): void {
    if (this.employeeList.length > 1) {
      this.amazaingManagementService.deleteEmployee(id);
      setTimeout(()=>{ this.getEmployeesByPlayer(this.currentPlayer); }, 100);
      setTimeout(()=>{ this.employee = this.employeeList[this.employeeList.length - 1] }, 200 );
    }
  }

  body(employee: EmployeeDTO): any {
    let employeeBody: any = {
      employeeName: employee.employeeName,
      photo: employee.photo,
      productivity: employee.productivity,
      clumsiness: employee.clumsiness,
      company: employee.companyId,
      player: employee.playerId
    }
    return employeeBody;
  }

  companyDetails(id: number): void {
    this.amazaingManagementService.getCompanyById(id).subscribe(result => {
      this.company = result;
    });
  }

  getCompanies(id: number): void {
    this.amazaingManagementService.getCompaniesByPlayerId(id).subscribe(result => {
      this.companyList = result;
    }, error => {
      console.log(error);
    });
  }

  selectCompanyDetails(id: number): void {
    this.amazaingManagementService.getCompanyById(id).subscribe(result => {
      this.selectedCompany = result;
    });
  }

  moveEmployee(): void {
    this.employee.companyId = this.selectedCompany.companyId;
    this.updateEmployee(this.employee.employeeId);
  }

}