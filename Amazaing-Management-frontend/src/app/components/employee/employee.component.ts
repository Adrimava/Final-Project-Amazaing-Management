import { Component, Input, OnInit } from '@angular/core';
import { EmployeeDTO } from 'src/app/models/employee-dto';
import { AmazaingManagementService } from 'src/app/services/amazaing-management.service';
import { Company, Employee } from 'src/app/services/interfaces/database.interface';

@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.css']
})
export class EmployeeComponent implements OnInit {

  @Input()
  currentPlayer: number = 1;
  employeeList: Employee[] = [];
  employee: Employee = null;
  employeeName: string = '';
  photo: string = 'Default picture';
  productivity: number = 0;
  clumsiness: number = 0;
  companyId: number = 0;
  player: number = 0;
  formIsVisible: boolean = false;
  company: Company = null;

  constructor(
    private amazaingManagementService: AmazaingManagementService
  ) { }

  ngOnInit(): void {
    this.getEmployees();
    setTimeout(()=>{ this.employeeDetails(this.employeeList[0].employeeId) }, 100);
  }

  getEmployees(): void {
    this.amazaingManagementService.getAllEmployees().subscribe(result => {
      this.employeeList = result;
    }, error => {
      console.log(error);
    });
  }

  employeeDetails(id: number): void {
    this.amazaingManagementService.getEmployeeById(id).subscribe(result => {
      this.employee = result;
    });
    setTimeout(()=>{ this.getEmployees() }, 100);
  }

  createEmployee(): void {
    let employee: EmployeeDTO = new EmployeeDTO(
      this.employeeName,
      this.photo,
      this.productivity,
      this.clumsiness,
      this.companyId,
      this.player
    );

    this.amazaingManagementService.storeEmployee(this.body(employee));
    this.employeeName = '';
    this.photo = '';
    this.productivity = 0;
    this.clumsiness = 0;
    this.companyId = 0;
    this.player = 0;
    setTimeout(()=>{ this.getEmployees(); }, 100);
  }

  updateEmployee(id: number): void {
    let employee: EmployeeDTO = new EmployeeDTO(
      this.employeeName,
      this.photo,
      this.productivity,
      this.clumsiness,
      this.companyId,
      this.player
    );

    this.amazaingManagementService.updateEmployee(id, this.body(employee));
    setTimeout(()=>{ this.getEmployees(); }, 100);
    setTimeout(()=>{ this.employee = this.employeeList[this.employeeList.length - 1] }, 200 );
  }

  deleteEmployee(id: number): void {
    if (this.employeeList.length > 1) {
      this.amazaingManagementService.deleteEmployee(id);
      setTimeout(()=>{ this.getEmployees(); }, 100);
      setTimeout(()=>{ this.employee = this.employeeList[this.employeeList.length - 1] }, 200 );
    }
  }

  body(employee: EmployeeDTO): any {
    let employeeBody: any = {
      employeeName: employee.employeeName,
      photo: employee.photo,
      productivity: employee.productivity,
      clumsiness: employee.clumsiness,
      companyId: employee.companyId,
      player: employee.playerId
    }
    return employeeBody;
  }

  companyDetails(id: number): void {
    this.amazaingManagementService.getCompanyById(id).subscribe(result => {
      this.company = result;
    });
  }

}