package com.ironhack.amazaingmanagementedgeservice.client;

import com.ironhack.amazaingmanagementedgeservice.controller.dto.EmployeeDTO;
import com.ironhack.amazaingmanagementedgeservice.model.Employee;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient("amazaing-management-employee-service")
public interface EmployeeClient {

	@GetMapping("/employees")
	@ResponseStatus(HttpStatus.OK)
	public List<Employee> getAllEmployees();

	@GetMapping("/employees-by-player/{playerId}")
	@ResponseStatus(HttpStatus.OK)
	public List<Employee> getEmployeesByPlayerId(@PathVariable Long playerId);

	@GetMapping("/employees-by-company/{companyId}")
	@ResponseStatus(HttpStatus.OK)
	public List<Employee> getEmployeesByCompanyId(@PathVariable Long companyId);

	@GetMapping("/employee/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Employee getEmployeeById(@PathVariable Long id);

	@PostMapping("/employee")
	@ResponseStatus(HttpStatus.CREATED)
	public Employee storeEmployee(@RequestBody EmployeeDTO employeeDTO);

	@PutMapping("/employee/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void updateEmployee(@PathVariable Long id, @RequestBody EmployeeDTO employeeDTO);

	@DeleteMapping("/employee/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteEmployee(@PathVariable Long id);

}
