package io.fireants.pitchersfriend.player;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@Service
public class PlayerService {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public Player getPlayer(Integer id) {
		try {
			logger.info("Retrieving player "+id);
			URL url = new URL("http://lookup-service-prod.mlb.com/json/named.player_info.bam?sport_code='mlb'&player_id='"+id+"'");
		    URLConnection request = url.openConnection();
		    request.connect();
	
		    JsonParser jp = new JsonParser();
		    JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
		    JsonObject playerObj = root.getAsJsonObject().get("player_info").getAsJsonObject().get("queryResults").getAsJsonObject().get("row").getAsJsonObject();
		    
		    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
			Date birthDate = formatter.parse(playerObj.get("birth_date").getAsString());
		    String firstName = playerObj.get("name_first").getAsString();
		    String lastName = playerObj.get("name_last").getAsString();
			String position = playerObj.get("primary_position_txt").getAsString();
			String bats = playerObj.get("bats").getAsString();
			String height = playerObj.get("height_feet").getAsString() + "' " + playerObj.get("height_inches").getAsString() + "\"";
			String weight = playerObj.get("weight").getAsString();
			String team = playerObj.get("team_name").getAsString();
		    
			Player player = new Player(id, firstName, lastName, position, bats, birthDate,height, weight, team);
			return player;
		} catch (Exception e) {
			logger.error("Error finding player", e);
			return null;
		}
	}
}
