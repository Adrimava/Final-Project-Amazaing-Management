package com.ironhack.companyservice.service.impl;

import com.ironhack.companyservice.client.BusinessModelClient;
import com.ironhack.companyservice.client.EmployeeClient;
import com.ironhack.companyservice.controller.dto.BusinessModelDTO;
import com.ironhack.companyservice.controller.dto.CompanyDTO;
import com.ironhack.companyservice.model.Company;
import com.ironhack.companyservice.repository.CompanyRepository;
import com.ironhack.companyservice.service.interfaces.ICompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CompanyService implements ICompanyService {

	@Autowired
	private CompanyRepository companyRepository;

	@Autowired
	private BusinessModelClient businessModelClient;

	@Autowired
	private EmployeeClient employeeClient;

	@Override
	public List<CompanyDTO> getAllCompanies() {
		List<Company> companyList = companyRepository.findAll();
		List<CompanyDTO> companyDTOList = new ArrayList<>();
		List<Long> employeeDTOList = new ArrayList<>();

		for (Company company : companyList) {
			BusinessModelDTO businessModelDTO = businessModelClient.getBusinessModelById(company.getBusinessModelId());
			companyDTOList.add(new CompanyDTO(company, businessModelDTO, employeeDTOList));
		}
		return companyDTOList;
	}

	@Override
	public List<CompanyDTO> getCompaniesByPlayerId(Long playerId) {
		List<Company> companyList = companyRepository.findByPlayerId(playerId);
		List<CompanyDTO> companyDTOList = new ArrayList<>();
		List<Long> employeeDTOList = new ArrayList<>();

		for (Company company : companyList) {
			BusinessModelDTO businessModelDTO = businessModelClient.getBusinessModelById(company.getBusinessModelId());
			companyDTOList.add(new CompanyDTO(company, businessModelDTO, employeeDTOList));
		}
		return companyDTOList;
	}

	@Override
	public CompanyDTO getCompanyById(Long id) {
		Optional<Company> company = companyRepository.findById(id);

		if(company.isPresent()) {
			BusinessModelDTO businessModelDTO = businessModelClient.getBusinessModelById(company.get().getBusinessModelId());
			List<Long> employeeDTOList = new ArrayList<>();
			CompanyDTO companyDTO = new CompanyDTO(company.get(), businessModelDTO, employeeDTOList);
			return companyDTO;
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
				companyDTO.getBusinessModelId(),
				companyDTO.getPlayerId()
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
				companyDTO.getBusinessModelId(),
				companyDTO.getPlayerId()
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
