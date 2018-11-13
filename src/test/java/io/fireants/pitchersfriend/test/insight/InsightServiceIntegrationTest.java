package io.fireants.pitchersfriend.test.insight;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import io.fireants.pitchersfriend.insight.Insight;
import io.fireants.pitchersfriend.insight.InsightRepository;
import io.fireants.pitchersfriend.insight.InsightService;
import io.fireants.pitchersfriend.insight.InsightServiceImpl;

@RunWith(SpringRunner.class)
public class InsightServiceIntegrationTest {
 
    @TestConfiguration
    static class InsightServiceImplTestContextConfiguration {
  
        @Bean
        public InsightService insightService() {
            return new InsightServiceImpl();
        }
    }
	
    @Autowired
    private InsightService insightService;
 
    @MockBean
    private InsightRepository insightRepository;
    
    @Before
    public void setUp() {
		long id = 519317;
		List<String> rightHandPitcherFindings = new ArrayList<String>(Arrays.asList("Keep curve balls in zone 4 or 5", "Don't throw a fast ball down the middle"));
		List<String> leftHandPitcherFindings = new ArrayList<String>(Arrays.asList("Only throw fast balls over 98mph", "He likes to swing at low pitches"));
	    Insight insight = new Insight(id, rightHandPitcherFindings, leftHandPitcherFindings);
	    
        Mockito.when(insightRepository.findOne(insight.getPlayerId()))
          .thenReturn(insight);
    }
    
    @Test
    public void whenValidName_thenEmployeeShouldBeFound() {
        long id = 519317;
        Insight found = insightService.findById(id);
      
        assertThat(found.getPlayerId()).isEqualTo(id);
     }
}