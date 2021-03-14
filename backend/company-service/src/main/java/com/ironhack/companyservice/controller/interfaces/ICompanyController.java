package com.ironhack.companyservice.controller.interfaces;

import com.ironhack.companyservice.controller.dto.CompanyDTO;
import com.ironhack.companyservice.model.Company;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface ICompanyController {

	List<CompanyDTO> getAllCompanies();
	public List<CompanyDTO> getCompaniesByPlayerId(Long playerId);
	CompanyDTO getCompanyById(Long id);
	Company storeCompany(CompanyDTO companyDTO);
	void updateCompany(Long id, CompanyDTO companyDTO);
	void deleteCompany(Long id);

}
