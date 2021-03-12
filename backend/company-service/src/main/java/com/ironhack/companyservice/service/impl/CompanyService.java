package com.ironhack.companyservice.service.impl;

import com.ironhack.companyservice.controller.dto.CompanyDTO;
import com.ironhack.companyservice.model.Company;
import com.ironhack.companyservice.repository.CompanyRepository;
import com.ironhack.companyservice.service.interfaces.ICompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyService implements ICompanyService {

	@Autowired
	private CompanyRepository companyRepository;

	@Override
	public List<Company> getAllCompanies() {
		return companyRepository.findAll();
	}

	@Override
	public List<Company> getCompaniesByPlayerId(Long playerId) {
		return companyRepository.findByPlayerId(playerId);
	}

	@Override
	public Company getCompanyById(Long id) {
		Optional<Company> company = companyRepository.findById(id);

		if(company.isPresent()) {
			return company.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Company not Found");
		}
	}

	@Override
	public Company storeCompany(CompanyDTO companyDTO) {
		Company company = new Company(
				companyDTO.getCompanyName(),
				companyDTO.getRevenue(),
				companyDTO.getMaintenance(),
				companyDTO.getEmployeesNumber(),
				companyDTO.getAccidentRiskIndex(),
				companyDTO.getBusinessModel(),
				companyDTO.getPlayer()
		);

		return companyRepository.save(company);
	}

	@Override
	public void updateCompany(Long id, CompanyDTO companyDTO) {
		Company company;

		getCompanyById(id);
		company = new Company(
				companyDTO.getCompanyName(),
				companyDTO.getRevenue(),
				companyDTO.getMaintenance(),
				companyDTO.getEmployeesNumber(),
				companyDTO.getAccidentRiskIndex(),
				companyDTO.getBusinessModel(),
				companyDTO.getPlayer()
		);
		company.setCompanyId(id);
		companyRepository.save(company);
	}

	@Override
	public void deleteCompany(Long id) {

		getCompanyById(id);
		companyRepository.deleteById(id);
	}

}
