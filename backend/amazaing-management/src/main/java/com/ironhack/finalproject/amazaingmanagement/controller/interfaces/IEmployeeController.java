package com.ironhack.finalproject.amazaingmanagement.controller.interfaces;

import com.ironhack.finalproject.amazaingmanagement.controller.dto.EmployeeDTO;
import com.ironhack.finalproject.amazaingmanagement.model.Employee;

import java.util.List;

public interface IEmployeeController {

	List<Employee> getAllEmployees();
	Employee getEmployeeById(Long id);
	Employee storeEmployee(EmployeeDTO employeeDTO);
	void updateEmployee(Long id, EmployeeDTO employeeDTO);
	void deleteEmployee(Long id);

}
