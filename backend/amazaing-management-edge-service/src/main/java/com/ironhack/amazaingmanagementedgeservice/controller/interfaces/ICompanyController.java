package com.ironhack.amazaingmanagementedgeservice.controller.interfaces;

import com.ironhack.amazaingmanagementedgeservice.controller.dto.CompanyDTO;
import com.ironhack.amazaingmanagementedgeservice.model.Company;

import java.util.List;

public interface ICompanyController {

	List<Company> getAllCompanies();
	public List<Company> getCompaniesByPlayerId(Long playerId);
	Company getCompanyById(Long id);
	Company storeCompany(CompanyDTO companyDTO);
	void updateCompany(Long id, CompanyDTO companyDTO);
	void deleteCompany(Long id);

}
