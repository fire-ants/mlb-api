package io.fireants.pitchersfriend.insight;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Insight {
	
	@Id
	private Long playerId;
	@ElementCollection
	private List<String> rightHandPitcherFindings;
	@ElementCollection
	private List<String> leftHandPitcherFindings;
	
	public Insight() {}

	public Insight(Long playerId, List<String> rightHandPitcherFindings, 
			List<String> leftHandPitcherFindings) {
		this.playerId = playerId;
		this.rightHandPitcherFindings = rightHandPitcherFindings;
		this.leftHandPitcherFindings = leftHandPitcherFindings;
	}
	
	public Long getPlayerId() {
		return playerId;
	}
	public void setPlayerId(Long playerId) {
		this.playerId = playerId;
	}
	public List<String> getRightHandPitcherFindings() {
		return rightHandPitcherFindings;
	}
	public void setRightHandPitcherFindings(List<String> rightHandPitcherFindings) {
		this.rightHandPitcherFindings = rightHandPitcherFindings;
	}
	public List<String> getLeftHandPitcherFindings() {
		return leftHandPitcherFindings;
	}
	public void setLeftHandPitcherFindings(List<String> leftHandPitcherFindings) {
		this.leftHandPitcherFindings = leftHandPitcherFindings;
	}
}
