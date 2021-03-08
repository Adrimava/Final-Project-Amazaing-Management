package com.ironhack.finalproject.amazaingmanagement.controller.dto;

import com.ironhack.finalproject.amazaingmanagement.model.Company;
import com.ironhack.finalproject.amazaingmanagement.model.Employee;
import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.util.List;

public class PlayerDTO {
	@NotEmpty
	private String playerName;
	@NotNull
	private BigDecimal money;
	private String photo;

	public PlayerDTO() {
	}

	public PlayerDTO(String playerName, BigDecimal money, String photo) {
		this.playerName = playerName;
		this.money = money;
		this.photo = photo;
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

}
