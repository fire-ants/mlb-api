package io.fireants.pitchersfriend.player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/player")
public class PlayerController {

	@Autowired
	private PlayerService playerService;

	@Cacheable(value = "player", key = "#id")
	@RequestMapping("/{id}")
	public Player getPlayer(@PathVariable Integer id) {
		return playerService.getPlayer(id);
	}
}
