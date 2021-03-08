package com.ironhack.finalproject.amazaingmanagement.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
public class Player {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long playerId;
	private String playerName;
	private BigDecimal money;
	private String photo;
	@OneToMany(mappedBy = "player")
	private List<Company> companies;
	@OneToMany(mappedBy = "player")
	private List<Employee> employees;

	public Player() {
	}

	public Player(String playerName, BigDecimal money, String photo) {
		this.playerName = playerName;
		this.money = money;
		this.photo = photo;
	}

	public Long getPlayerId() {
		return playerId;
	}

	public void setPlayerId(Long playerId) {
		this.playerId = playerId;
	}

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

	public List<Company> getCompanies() {
		return companies;
	}

	public void setCompanies(List<Company> companies) {
		this.companies = companies;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
}
