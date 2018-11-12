package io.fireants.pitchersfriend.insight;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InsightController {

	@Autowired
	private InsightService insightService;

	@GetMapping("/player/{id}/insight")
	public ResponseEntity<Insight> findByPlayerId(@PathVariable Long id) {
		Insight insight = insightService.findById(id);
		if (insight == null) {
			return new ResponseEntity<Insight>(HttpStatus.NOT_FOUND);
	    } else {
	    		return new ResponseEntity<Insight>(insight, HttpStatus.OK);
	    }
	}
	
	@PostMapping("/player/{id}/insight")
	public Insight save(@Valid @RequestBody Insight insight, @PathVariable Long id) {
		insight.setPlayerId(id);
		return insightService.save(insight);
	}
}