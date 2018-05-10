package io.fireants.pitchersfriend.player;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class PlayerService {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public Player getPlayer(Integer id) {
		try {
			logger.info("Retrieving player "+id+" from mlb.com");
			Document doc = Jsoup.connect("http://m.mlb.com/player/"+id).get();
			Element element = doc.getElementById("page-variables");
			
			String html = element.html();
			int index = html.indexOf("var playerData = ") + 17;
			String json = html.substring(index);
			
			JSONParser parser = new JSONParser();
			JSONObject playerData = (JSONObject) parser.parse(json);
			
			JSONObject playerInfo = (JSONObject) playerData.get("player_info");
			JSONObject playerTeam = (JSONObject) playerData.get("player_team");
			
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
			Date date = formatter.parse( (String) playerInfo.get("pi_birth_date"));
			
			String firstName = (String) playerInfo.get("pi_name_first");
			String lastName = (String) playerInfo.get("pi_name_last");
			String position = (String) playerInfo.get("pi_primary_position_txt");
			String bats = (String) playerInfo.get("pi_bats");
			String height = (String) playerInfo.get("pi_height_feet") + "' " 
					+ (String) playerInfo.get("pi_height_feet") + "\"";
			String weight = (String) playerInfo.get("display_weight") + "lbs";
			String team = (String) playerTeam.get("pt_org_full");
			
			Player player = new Player(id, firstName, lastName, position, bats, date,
					height, weight, team);

			return player;
		} catch (Exception e) {
			return null;
		}
	}
}
