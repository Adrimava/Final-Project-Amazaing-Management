package com.ironhack.amazaingmanagementedgeservice.controller.interfaces;

import com.ironhack.amazaingmanagementedgeservice.controller.dto.EmployeeDTO;
import com.ironhack.amazaingmanagementedgeservice.model.Employee;

import java.util.List;

public interface IEmployeeController {

	List<Employee> getAllEmployees();
	public List<Employee> getEmployeesByPlayerId(Long playerId);
	public List<Employee> getEmployeesByCompanyId(Long companyId);
	Employee getEmployeeById(Long id);
	Employee storeEmployee(EmployeeDTO employeeDTO);
	void updateEmployee(Long id, EmployeeDTO employeeDTO);
	void deleteEmployee(Long id);

}
