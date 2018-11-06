package io.fireants.pitchersfriend.player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<Player> getPlayer(@PathVariable Integer id) {
		Player player = playerService.getPlayer(id);
		if (player == null) {
			return new ResponseEntity<Player>(HttpStatus.NOT_FOUND);
	    } else {
	    		return new ResponseEntity<Player>(player, HttpStatus.OK);
	    }
	}
}
