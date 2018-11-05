package io.fireants.pitchersfriend.player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/player")
public class PlayerController {

	@Autowired
	private PlayerService playerService;

	@GetMapping("/{id}")
	public Player  getPlayer(@PathVariable Integer id) {
		return playerService.getPlayer(id);
	}
}
