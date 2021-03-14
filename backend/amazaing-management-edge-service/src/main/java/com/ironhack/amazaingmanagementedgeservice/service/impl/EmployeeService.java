package com.ironhack.amazaingmanagementedgeservice.service.impl;

import com.ironhack.amazaingmanagementedgeservice.client.EmployeeClient;
import com.ironhack.amazaingmanagementedgeservice.controller.dto.EmployeeDTO;
import com.ironhack.amazaingmanagementedgeservice.model.Company;
import com.ironhack.amazaingmanagementedgeservice.model.Employee;
import com.ironhack.amazaingmanagementedgeservice.service.interfaces.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JCircuitBreakerFactory;
import org.springframework.cloud.client.circuitbreaker.CircuitBreaker;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements IEmployeeService {

	@Autowired
	private EmployeeClient employeeClient;

	private CircuitBreakerFactory circuitBreakerFactory = new Resilience4JCircuitBreakerFactory();

	private List<Employee> allEmployeeFallBack() {
		return null;
	}

	private Employee employeeFallBack() {
		return null;
	}

	@Override
	public List<Employee> getAllEmployees() {
		CircuitBreaker circuitBreaker = circuitBreakerFactory.create("amazaing-management-employee-service");

		List<Employee> employeeList = circuitBreaker.run(() -> employeeClient.getAllEmployees(),
				throwable -> allEmployeeFallBack());

		return employeeList;
	}

	@Override
	public List<Employee> getEmployeesByPlayerId(Long playerId) {
		CircuitBreaker circuitBreaker = circuitBreakerFactory.create("amazaing-management-employee-service");

		List<Employee> employeeList = circuitBreaker.run(() -> employeeClient.getEmployeesByPlayerId(playerId),
				throwable -> allEmployeeFallBack());

		return employeeList;
	}

	@Override
	public List<Employee> getEmployeesByCompanyId(Long companyId) {
		CircuitBreaker circuitBreaker = circuitBreakerFactory.create("amazaing-management-employee-service");

		List<Employee> employeeList = circuitBreaker.run(() -> employeeClient.getEmployeesByCompanyId(companyId),
				throwable -> allEmployeeFallBack());

		return employeeList;
	}

	@Override
	public Employee getEmployeeById(Long id) {
		CircuitBreaker circuitBreaker = circuitBreakerFactory.create("amazaing-management-employee-service");

		Employee employee = circuitBreaker.run(() -> employeeClient.getEmployeeById(id),
				throwable -> employeeFallBack());

		return employee;
	}

	@Override
	public Employee storeEmployee(EmployeeDTO employeeDTO) {
		CircuitBreaker circuitBreaker = circuitBreakerFactory.create("amazaing-management-employee-service");

		Employee employee = circuitBreaker.run(() -> employeeClient.storeEmployee(employeeDTO),
				throwable -> employeeFallBack());

		return employee;
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
