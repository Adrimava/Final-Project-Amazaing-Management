package com.ironhack.amazaingmanagementedgeservice.service.impl;

import com.ironhack.amazaingmanagementedgeservice.controller.dto.EmployeeDTO;
import com.ironhack.amazaingmanagementedgeservice.model.Employee;
import com.ironhack.amazaingmanagementedgeservice.repository.EmployeeRepository;
import com.ironhack.amazaingmanagementedgeservice.service.interfaces.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService implements IEmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private CompanyService companyService;

	@Autowired
	private PlayerService playerService;

	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee getEmployeeById(Long id) {
		Optional<Employee> employee = employeeRepository.findById(id);

		if(employee.isPresent()) {
			return employee.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not found");
		}
	}

	@Override
	public Employee storeEmployee(EmployeeDTO employeeDTO) {
		Employee employee = new Employee(
				employeeDTO.getEmployeeName(),
				employeeDTO.getPhoto(),
				employeeDTO.getProductivity(),
				employeeDTO.getClumsiness(),
				companyService.getCompanyById(employeeDTO.getCompany()),
				playerService.getPlayerById(employeeDTO.getPlayer())
		);

		return employeeRepository.save(employee);
	}

	@Override
	public void updateEmployee(Long id, EmployeeDTO employeeDTO) {
		Employee employee;

		getEmployeeById(id);
		employee = new Employee(
				employeeDTO.getEmployeeName(),
				employeeDTO.getPhoto(),
				employeeDTO.getProductivity(),
				employeeDTO.getClumsiness(),
				companyService.getCompanyById(employeeDTO.getCompany()),
				playerService.getPlayerById(employeeDTO.getPlayer())
		);
		employee.setEmployeeId(id);
		employeeRepository.save(employee);
	}

	@Override
	public void deleteEmployee(Long id) {

		getEmployeeById(id);
		employeeRepository.deleteById(id);
	}

}
