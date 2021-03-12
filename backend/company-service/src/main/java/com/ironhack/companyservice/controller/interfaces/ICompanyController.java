package com.ironhack.companyservice.controller.interfaces;

import com.ironhack.companyservice.controller.dto.CompanyDTO;
import com.ironhack.companyservice.model.Company;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface ICompanyController {

	List<Company> getAllCompanies();
	public List<Company> getCompaniesByPlayerId(Long playerId);
	Company getCompanyById(Long id);
	Company storeCompany(CompanyDTO companyDTO);
	void updateCompany(Long id, CompanyDTO companyDTO);
	void deleteCompany(Long id);

}
