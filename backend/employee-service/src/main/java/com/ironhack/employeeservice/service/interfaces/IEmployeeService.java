package com.ironhack.employeeservice.service.interfaces;

import com.ironhack.employeeservice.controller.dto.EmployeeDTO;
import com.ironhack.employeeservice.model.Employee;

import java.util.List;

public interface IEmployeeService {

	List<Employee> getAllEmployees();
	public List<Employee> getEmployeesByPlayerId(Long playerId);
	public List<Employee> getEmployeesByCompanyId(Long companyId);
	Employee getEmployeeById(Long id);
	Employee storeEmployee(EmployeeDTO employeeDTO);
	void updateEmployee(Long id, EmployeeDTO employeeDTO);
	void deleteEmployee(Long id);

}
