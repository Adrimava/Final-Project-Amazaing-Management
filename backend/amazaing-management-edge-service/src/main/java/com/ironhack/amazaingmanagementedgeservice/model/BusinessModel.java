package com.ironhack.amazaingmanagementedgeservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.math.BigDecimal;
import java.util.List;

@Entity
public class BusinessModel {
	@Id
	private Long modelId;
	private String modelName;
	private String photo;
	private BigDecimal purchasePrice;
	private Integer maxEmployees;
	private BigDecimal averageRevenue;
	private BigDecimal dailyCosts;
	private BigDecimal employeeSalary;
	@JsonIgnore
	@OneToMany(mappedBy = "businessModel")
	private List<Company> companies;

	public BusinessModel() {
	}

	public BusinessModel(Long modelId, String modelName, String photo,
						 BigDecimal purchasePrice, Integer maxEmployees,
						 BigDecimal averageRevenue, BigDecimal dailyCosts,
						 BigDecimal employeeSalary) {
		this.modelId = modelId;
		this.modelName = modelName;
		this.photo = photo;
		this.purchasePrice = purchasePrice;
		this.maxEmployees = maxEmployees;
		this.averageRevenue = averageRevenue;
		this.dailyCosts = dailyCosts;
		this.employeeSalary = employeeSalary;
	}

	public Long getModelId() {
		return modelId;
	}

	public void setModelId(Long modelId) {
		this.modelId = modelId;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public BigDecimal getPurchasePrice() {
		return purchasePrice;
	}

	public void setPurchasePrice(BigDecimal purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	public Integer getMaxEmployees() {
		return maxEmployees;
	}

	public void setMaxEmployees(Integer maxEmployees) {
		this.maxEmployees = maxEmployees;
	}

	public BigDecimal getAverageRevenue() {
		return averageRevenue;
	}

	public void setAverageRevenue(BigDecimal averageRevenue) {
		this.averageRevenue = averageRevenue;
	}

	public BigDecimal getDailyCosts() {
		return dailyCosts;
	}

	public void setDailyCosts(BigDecimal dailyCosts) {
		this.dailyCosts = dailyCosts;
	}

	public BigDecimal getEmployeeSalary() {
		return employeeSalary;
	}

	public void setEmployeeSalary(BigDecimal employeeSalary) {
		this.employeeSalary = employeeSalary;
	}

	public List<Company> getCompanies() {
		return companies;
	}

	public void setCompanies(List<Company> companies) {
		this.companies = companies;
	}
}
