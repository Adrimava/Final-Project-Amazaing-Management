import { Component, OnInit } from '@angular/core';
import { EmployeeDTO } from 'src/app/models/employee-dto';
import { AmazaingManagementService } from 'src/app/services/amazaing-management.service';
import { Employee } from 'src/app/services/interfaces/database.interface';

@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.css']
})
export class EmployeeComponent implements OnInit {

  employeeList: Employee[] = [];
  employee: Employee = null;
  employeeName: string = '';
  photo: string = 'Default picture';
  productivity: number = 0;
  clumsiness: number = 0;
  company: number = 0;
  player: number = 0;
  formIsVisible: boolean = false;

  constructor(
    private amazaingManagementService: AmazaingManagementService
  ) { }

  ngOnInit(): void {
    this.getEmployees();
    this.employeeDetails(1);
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
  }

  createEmployee(): void {
    let employee: EmployeeDTO = new EmployeeDTO(
      this.employeeName,
      this.photo,
      this.productivity,
      this.clumsiness,
      this.company,
      this.player
    );

    this.amazaingManagementService.storeEmployee(this.body(employee));
    this.employeeName = '';
    this.photo = '';
    this.productivity = 0;
    this.clumsiness = 0;
    this.company = 0;
    this.player = 0;
  }

  updateEmployee(id: number): void {
    let employee: EmployeeDTO = new EmployeeDTO(
      this.employeeName,
      this.photo,
      this.productivity,
      this.clumsiness,
      this.company,
      this.player
    );

    this.amazaingManagementService.updateEmployee(id, this.body(employee));
  }

  deleteEmployee(id: number): void {
    this.amazaingManagementService.deleteEmployee(id);
  }

  body(employee: EmployeeDTO): any {
    let employeeBody: any = {
      employeeName: employee.employeeName,
      photo: employee.photo,
      productivity: employee.productivity,
      clumsiness: employee.clumsiness,
      company: employee.company,
      player: employee.player
    }
    return employeeBody;
  }

}