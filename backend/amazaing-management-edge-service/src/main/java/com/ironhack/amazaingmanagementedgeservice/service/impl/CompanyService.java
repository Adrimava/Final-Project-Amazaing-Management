package com.ironhack.amazaingmanagementedgeservice.service.impl;

import com.ironhack.amazaingmanagementedgeservice.client.CompanyClient;
import com.ironhack.amazaingmanagementedgeservice.controller.dto.CompanyDTO;
import com.ironhack.amazaingmanagementedgeservice.model.BusinessModel;
import com.ironhack.amazaingmanagementedgeservice.model.Company;
import com.ironhack.amazaingmanagementedgeservice.service.interfaces.ICompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JCircuitBreakerFactory;
import org.springframework.cloud.client.circuitbreaker.CircuitBreaker;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService implements ICompanyService {

	@Autowired
	private CompanyClient companyClient;

	private CircuitBreakerFactory circuitBreakerFactory = new Resilience4JCircuitBreakerFactory();

	private List<Company> allCompanyFallBack() {
		return null;
	}

	private Company companyFallBack() {
		return null;
	}

	@Override
	public List<Company> getAllCompanies() {
		CircuitBreaker circuitBreaker = circuitBreakerFactory.create("amazaing-management-company-service");

		List<Company> companyList = circuitBreaker.run(() -> companyClient.getAllCompanies(),
				throwable -> allCompanyFallBack());

		return companyList;
	}

	@Override
	public List<Company> getCompaniesByPlayerId(Long playerId) {
		CircuitBreaker circuitBreaker = circuitBreakerFactory.create("amazaing-management-company-service");

		List<Company> companyList = circuitBreaker.run(() -> companyClient.getCompaniesByPlayerId(playerId),
				throwable -> allCompanyFallBack());

		return companyList;
	}

	@Override
	public Company getCompanyById(Long id) {
		CircuitBreaker circuitBreaker = circuitBreakerFactory.create("amazaing-management-company-service");

		Company company = circuitBreaker.run(() -> companyClient.getCompanyById(id),
				throwable -> companyFallBack());

		return company;
	}

	@Override
	public Company storeCompany(CompanyDTO companyDTO) {
		CircuitBreaker circuitBreaker = circuitBreakerFactory.create("amazaing-management-company-service");
		Company company = circuitBreaker.run(() -> companyClient.storeCompany(companyDTO),
				throwable -> companyFallBack());

		return company;
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
