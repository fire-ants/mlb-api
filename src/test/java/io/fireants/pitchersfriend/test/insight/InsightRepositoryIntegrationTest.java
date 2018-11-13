package io.fireants.pitchersfriend.test.insight;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import io.fireants.pitchersfriend.insight.Insight;
import io.fireants.pitchersfriend.insight.InsightRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class InsightRepositoryIntegrationTest {
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private InsightRepository insightRepository;
	
	@Test
	public void whenFindById_thenReturnInsight() {
		long id = 519317;
		List<String> rightHandPitcherFindings = new ArrayList<String>(Arrays.asList("Keep curve balls in zone 4 or 5", "Don't throw a fast ball down the middle"));
		List<String> leftHandPitcherFindings = new ArrayList<String>(Arrays.asList("Only throw fast balls over 98mph", "He likes to swing at low pitches"));
	    Insight insight = new Insight(id, rightHandPitcherFindings, leftHandPitcherFindings);
	    
	    entityManager.persistAndFlush(insight);

	    Insight found = insightRepository.findOne(insight.getPlayerId());
	 
	    assertThat(found.getPlayerId()).isEqualTo(insight.getPlayerId());
	    assertThat(found.getLeftHandPitcherFindings()).isEqualTo(insight.getLeftHandPitcherFindings());
	    assertThat(found.getRightHandPitcherFindings()).isEqualTo(insight.getRightHandPitcherFindings());
	}
}
