package com.ironhack.amazaingmanagementedgeservice.client;

import com.ironhack.amazaingmanagementedgeservice.controller.dto.PlayerDTO;
import com.ironhack.amazaingmanagementedgeservice.model.Player;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient("amazaing-management-player-service")
public interface PlayerClient {

	@GetMapping("/players")
	@ResponseStatus(HttpStatus.OK)
	public List<Player> getAllPlayers();

	@GetMapping("/player/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Player getPlayerById(@PathVariable Long id);

	@PostMapping("/player")
	@ResponseStatus(HttpStatus.CREATED)
	public Player storePlayer(@RequestBody PlayerDTO playerDTO);

	@PutMapping("/player/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void updatePlayer(@PathVariable Long id, @RequestBody PlayerDTO playerDTO);

	@DeleteMapping("/player/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletePlayer(@PathVariable Long id);

}
