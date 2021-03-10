package com.ironhack.employeeservice.service.impl;

import com.ironhack.employeeservice.controller.dto.EmployeeDTO;
import com.ironhack.employeeservice.model.Employee;
import com.ironhack.employeeservice.repository.EmployeeRepository;
import com.ironhack.employeeservice.service.interfaces.IEmployeeService;
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
				employeeDTO.getCompany(),
				employeeDTO.getPlayer()
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
				employeeDTO.getCompany(),
				employeeDTO.getPlayer()
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
