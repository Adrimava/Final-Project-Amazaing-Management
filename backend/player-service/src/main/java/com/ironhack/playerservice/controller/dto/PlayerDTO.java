package com.ironhack.playerservice.controller.dto;

import com.sun.istack.NotNull;

import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.util.List;

public class PlayerDTO {
	@NotEmpty
	private String playerName;
	@NotNull
	private BigDecimal money;
	private String photo;
	private List<Long> companies;
	private List<Long> employees;

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public BigDecimal getMoney() {
		return money;
	}

	public void setMoney(BigDecimal money) {
		this.money = money;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public List<Long> getCompanies() {
		return companies;
	}

	public void setCompanies(List<Long> companies) {
		this.companies = companies;
	}

	public List<Long> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Long> employees) {
		this.employees = employees;
	}
}
