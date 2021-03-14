package com.ironhack.companyservice.service.interfaces;

import com.ironhack.companyservice.controller.dto.CompanyDTO;
import com.ironhack.companyservice.model.Company;

import java.util.List;

public interface ICompanyService {

	List<CompanyDTO> getAllCompanies();
	public List<CompanyDTO> getCompaniesByPlayerId(Long playerId);
	CompanyDTO getCompanyById(Long id);
	Company storeCompany(CompanyDTO companyDTO);
	void updateCompany(Long id, CompanyDTO companyDTO);
	void deleteCompany(Long id);

}
