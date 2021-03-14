package com.ironhack.companyservice.client;

import com.ironhack.companyservice.controller.dto.EmployeeDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient("amazaing-management-employee-service")
public interface EmployeeClient {

	@GetMapping("/employees-by-company/{companyId}")
	@ResponseStatus(HttpStatus.OK)
	public List<EmployeeDTO> getEmployeesByCompanyId(@PathVariable Long companyId);

	@GetMapping("/employee/{id}")
	@ResponseStatus(HttpStatus.OK)
	public EmployeeDTO getEmployeeById(@PathVariable Long id);

}
