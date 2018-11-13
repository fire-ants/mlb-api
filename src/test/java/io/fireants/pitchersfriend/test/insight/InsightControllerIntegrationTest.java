package io.fireants.pitchersfriend.test.insight;

import static org.mockito.BDDMockito.given;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import io.fireants.pitchersfriend.insight.Insight;
import io.fireants.pitchersfriend.insight.InsightController;
import io.fireants.pitchersfriend.insight.InsightService;

@RunWith(SpringRunner.class)
@WebMvcTest(InsightController.class)
public class InsightControllerIntegrationTest {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private InsightService service;
	
	@Test
	public void givenInsight_whenGetInsight_thenReturnJsonObject()
	  throws Exception {
	     
		long id = 519317;
		List<String> rightHandPitcherFindings = new ArrayList<String>(Arrays.asList("Keep curve balls in zone 4 or 5", "Don't throw a fast ball down the middle"));
		List<String> leftHandPitcherFindings = new ArrayList<String>(Arrays.asList("Only throw fast balls over 98mph", "He likes to swing at low pitches"));
	    Insight insight = new Insight(id, rightHandPitcherFindings, leftHandPitcherFindings);
	 
	    given(service.findById(id)).willReturn(insight);
	 
	    mvc.perform(get("/player/519317/insight")
	      .contentType(MediaType.APPLICATION_JSON))
	      .andExpect(status().isOk());
	}
}