package com.ironhack.companyservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class CompanyEmployees {
	@Id
	private Long employeeId;
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "company_id")
	private Company company;

	public CompanyEmployees() {
	}

	public CompanyEmployees(Long employeeId, Company company) {
		this.employeeId = employeeId;
		this.company = company;
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}
}
