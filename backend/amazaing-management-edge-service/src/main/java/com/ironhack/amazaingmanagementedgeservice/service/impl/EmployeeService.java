package com.ironhack.amazaingmanagementedgeservice.service.impl;

import com.ironhack.amazaingmanagementedgeservice.client.EmployeeClient;
import com.ironhack.amazaingmanagementedgeservice.controller.dto.EmployeeDTO;
import com.ironhack.amazaingmanagementedgeservice.model.Employee;
import com.ironhack.amazaingmanagementedgeservice.service.interfaces.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements IEmployeeService {

	@Autowired
	private EmployeeClient employeeClient;

	@Override
	public List<Employee> getAllEmployees() {

		return employeeClient.getAllEmployees();
	}

	@Override
	public List<Employee> getEmployeesByPlayerId(Long playerId) {
		return employeeClient.getEmployeesByPlayerId(playerId);
	}

	@Override
	public List<Employee> getEmployeesByCompanyId(Long companyId) {
		return employeeClient.getEmployeesByCompanyId(companyId);
	}

	@Override
	public Employee getEmployeeById(Long id) {

		return employeeClient.getEmployeeById(id);
	}

	@Override
	public Employee storeEmployee(EmployeeDTO employeeDTO) {

		return employeeClient.storeEmployee(employeeDTO);
	}

	@Override
	public void updateEmployee(Long id, EmployeeDTO employeeDTO) {

		employeeClient.updateEmployee(id, employeeDTO);
	}

	@Override
	public void deleteEmployee(Long id) {

		employeeClient.deleteEmployee(id);
	}

}
