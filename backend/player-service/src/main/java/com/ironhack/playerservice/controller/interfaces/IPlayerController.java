package com.ironhack.playerservice.controller.interfaces;

import com.ironhack.playerservice.controller.dto.PlayerDTO;
import com.ironhack.playerservice.model.Player;

import java.util.List;

public interface IPlayerController {

	List<Player> getAllPlayers();
	Player getPlayerById(Long id);
	Player storePlayer(PlayerDTO playerDTO);
	void updatePlayer(Long id, PlayerDTO playerDTO);
	void deletePlayer(Long id);

}
