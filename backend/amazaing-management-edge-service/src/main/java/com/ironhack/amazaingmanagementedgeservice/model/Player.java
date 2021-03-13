package com.ironhack.amazaingmanagementedgeservice.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

public class Player {

	private Long playerId;
	private String playerName;
	private BigDecimal money;
	private String photo;

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

}
