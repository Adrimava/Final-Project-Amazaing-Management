package com.ironhack.amazaingmanagementedgeservice.service.impl;

import com.ironhack.amazaingmanagementedgeservice.client.CompanyClient;
import com.ironhack.amazaingmanagementedgeservice.controller.dto.CompanyDTO;
import com.ironhack.amazaingmanagementedgeservice.model.Company;
import com.ironhack.amazaingmanagementedgeservice.service.interfaces.ICompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService implements ICompanyService {

	@Autowired
	private CompanyClient companyClient;

	@Override
	public List<Company> getAllCompanies() {

		return companyClient.getAllCompanies();
	}

	@Override
	public Company getCompanyById(Long id) {

		return companyClient.getCompanyById(id);
	}

	@Override
	public Company storeCompany(CompanyDTO companyDTO) {

		return companyClient.storeCompany(companyDTO);
	}

	@Override
	public void updateCompany(Long id, CompanyDTO companyDTO) {

		companyClient.updateCompany(id, companyDTO);
	}

	@Override
	public void deleteCompany(Long id) {

		companyClient.deleteCompany(id);
	}

}
