package com.ironhack.amazaingmanagementedgeservice.controller.impl;

import com.ironhack.amazaingmanagementedgeservice.controller.dto.CompanyDTO;
import com.ironhack.amazaingmanagementedgeservice.controller.interfaces.ICompanyController;
import com.ironhack.amazaingmanagementedgeservice.model.Company;
import com.ironhack.amazaingmanagementedgeservice.service.interfaces.ICompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class CompanyController implements ICompanyController {

	@Autowired
	private ICompanyService companyService;

	@GetMapping("/companies")
	@ResponseStatus(HttpStatus.OK)
	public List<Company> getAllCompanies() {
		return companyService.getAllCompanies();
	}

	@GetMapping("/companies-by-player/{playerId}")
	@ResponseStatus(HttpStatus.OK)
	public List<Company> getCompaniesByPlayerId(@PathVariable Long playerId) {
		return companyService.getCompaniesByPlayerId(playerId);
	}

	@GetMapping("/company/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Company getCompanyById(@PathVariable Long id) {
		return companyService.getCompanyById(id);
	}

	@PostMapping("/company")
	@ResponseStatus(HttpStatus.CREATED)
	public Company storeCompany(@RequestBody CompanyDTO companyDTO) {
		return companyService.storeCompany(companyDTO);
	}

	@PutMapping("/company/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void updateCompany(@PathVariable Long id, @RequestBody CompanyDTO companyDTO) {
		companyService.updateCompany(id, companyDTO);
	}

	@DeleteMapping("/company/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteCompany(@PathVariable Long id) {
		companyService.deleteCompany(id);
	}
}
