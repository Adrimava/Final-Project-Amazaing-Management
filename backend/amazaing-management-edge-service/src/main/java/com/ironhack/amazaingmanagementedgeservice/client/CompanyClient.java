package com.ironhack.amazaingmanagementedgeservice.client;

import com.ironhack.amazaingmanagementedgeservice.controller.dto.CompanyDTO;
import com.ironhack.amazaingmanagementedgeservice.model.Company;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient("amazaing-management-company-service")
public interface CompanyClient {

	@GetMapping("/companies")
	@ResponseStatus(HttpStatus.OK)
	public List<Company> getAllCompanies();

	@GetMapping("/companies-by-player/{playerId}")
	@ResponseStatus(HttpStatus.OK)
	public List<Company> getCompaniesByPlayerId(@PathVariable Long playerId);

	@GetMapping("/company/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Company getCompanyById(@PathVariable Long id);

	@PostMapping("/company")
	@ResponseStatus(HttpStatus.CREATED)
	public Company storeCompany(@RequestBody CompanyDTO companyDTO);

	@PutMapping("/company/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void updateCompany(@PathVariable Long id, @RequestBody CompanyDTO companyDTO);

	@DeleteMapping("/company/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteCompany(@PathVariable Long id);

}
