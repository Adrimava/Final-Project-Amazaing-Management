package com.ironhack.playerservice.controller.impl;

import com.ironhack.playerservice.controller.dto.PlayerDTO;
import com.ironhack.playerservice.controller.interfaces.IPlayerController;
import com.ironhack.playerservice.model.Player;
import com.ironhack.playerservice.service.interfaces.IPlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class PlayerController implements IPlayerController {

	@Autowired
	private IPlayerService playerService;

	@GetMapping("/players")
	@ResponseStatus(HttpStatus.OK)
	public List<Player> getAllPlayers() {
		return playerService.getAllPlayers();
	}

	@GetMapping("/player/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Player getPlayerById(@PathVariable Long id) {
		return playerService.getPlayerById(id);
	}

	@PostMapping("/player")
	@ResponseStatus(HttpStatus.CREATED)
	public Player storePlayer(@RequestBody PlayerDTO playerDTO) {
		return playerService.storePlayer(playerDTO);
	}

	@PutMapping("/player/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void updatePlayer(@PathVariable Long id, @RequestBody PlayerDTO playerDTO) {
		playerService.updatePlayer(id, playerDTO);
	}

	@DeleteMapping("/player/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletePlayer(@PathVariable Long id) {
		playerService.deletePlayer(id);
	}

}
