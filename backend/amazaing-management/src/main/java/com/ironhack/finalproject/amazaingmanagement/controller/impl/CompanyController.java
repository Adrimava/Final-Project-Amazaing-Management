package com.ironhack.finalproject.amazaingmanagement.controller.impl;

import com.ironhack.finalproject.amazaingmanagement.controller.dto.CompanyDTO;
import com.ironhack.finalproject.amazaingmanagement.controller.interfaces.ICompanyController;
import com.ironhack.finalproject.amazaingmanagement.model.Company;
import com.ironhack.finalproject.amazaingmanagement.service.interfaces.ICompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CompanyController implements ICompanyController {

	@Autowired
	private ICompanyService companyService;

	@GetMapping("/companies")
	@ResponseStatus(HttpStatus.OK)
	public List<Company> getAllCompanies() {
		return companyService.getAllCompanies();
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
