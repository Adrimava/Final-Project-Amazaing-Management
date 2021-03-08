package com.ironhack.finalproject.amazaingmanagement.controller.interfaces;

import com.ironhack.finalproject.amazaingmanagement.controller.dto.CompanyDTO;
import com.ironhack.finalproject.amazaingmanagement.model.Company;

import java.util.List;

public interface ICompanyController {

	List<Company> getAllCompanies();
	Company getCompanyById(Long id);
	Company storeCompany(CompanyDTO companyDTO);
	void updateCompany(Long id, CompanyDTO companyDTO);
	void deleteCompany(Long id);

}
