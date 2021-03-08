package com.ironhack.finalproject.amazaingmanagement.controller.dto;

import com.ironhack.finalproject.amazaingmanagement.model.BusinessModel;
import com.ironhack.finalproject.amazaingmanagement.model.Employee;
import com.ironhack.finalproject.amazaingmanagement.model.Player;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

public class CompanyDTO {
	@NotEmpty
	private String companyName;
	private BigDecimal revenue;
	private BigDecimal maintenance;
	private Integer employeesNumber;
	private BigDecimal accidentRiskIndex;
	@NotNull
	private BusinessModel businessModel;
	@NotNull
	private Player player;

	public CompanyDTO() {
	}

	public CompanyDTO(String companyName, BigDecimal revenue, BigDecimal maintenance,
					  Integer employeesNumber, BigDecimal accidentRiskIndex,
					  BusinessModel businessModel, Player player) {
		this.companyName = companyName;
		this.revenue = revenue;
		this.maintenance = maintenance;
		this.employeesNumber = employeesNumber;
		this.accidentRiskIndex = accidentRiskIndex;
		this.businessModel = businessModel;
		this.player = player;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public BigDecimal getRevenue() {
		return revenue;
	}

	public void setRevenue(BigDecimal revenue) {
		this.revenue = revenue;
	}

	public BigDecimal getMaintenance() {
		return maintenance;
	}

	public void setMaintenance(BigDecimal maintenance) {
		this.maintenance = maintenance;
	}

	public Integer getEmployeesNumber() {
		return employeesNumber;
	}

	public void setEmployeesNumber(Integer employeesNumber) {
		this.employeesNumber = employeesNumber;
	}

	public BigDecimal getAccidentRiskIndex() {
		return accidentRiskIndex;
	}

	public void setAccidentRiskIndex(BigDecimal accidentRiskIndex) {
		this.accidentRiskIndex = accidentRiskIndex;
	}

	public BusinessModel getBusinessModel() {
		return businessModel;
	}

	public void setBusinessModel(BusinessModel businessModel) {
		this.businessModel = businessModel;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

}
