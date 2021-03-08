package com.ironhack.finalproject.amazaingmanagement.service.interfaces;

import com.ironhack.finalproject.amazaingmanagement.controller.dto.PlayerDTO;
import com.ironhack.finalproject.amazaingmanagement.model.Player;

import java.util.List;

public interface IPlayerService {

	List<Player> getAllPlayers();
	Player getPlayerById(Long id);
	Player storePlayer(PlayerDTO playerDTO);
	void updatePlayer(Long id, PlayerDTO playerDTO);
	void deletePlayer(Long id);

}
