package com.rdpairs.controllers;

import com.rdpairs.dao.DeltenPlayerDAO;
import com.rdpairs.models.DeltenPlayer;

import java.util.ArrayList;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DeltenPlayerController {
	
	@Autowired
	private DeltenPlayerDAO deltenPlayerDAO;

	/**
	* /get_players  --> Return all the players
	* 
	* @return The players on the DB.
	*/
	@RequestMapping("/get_players")
	@ResponseBody
	public ArrayList<DeltenPlayer> getAllPlayers() {
		ArrayList<DeltenPlayer> lPlayers = new ArrayList<>();
		try {
	    	lPlayers = deltenPlayerDAO.findAll();
	    }
	    catch (Exception ex) {
			return null;
	    }
	    return lPlayers;
	}

	/**
	* /get_pairs  --> Return all the players
	* 
	* @return The players on the DB.
	*/
	@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, value="/get_pairs")
	@ResponseBody
	public String getPairs(@RequestParam (value="sprintDays") int sprintDays, @RequestParam(value ="pairDuration") int pairDuration) {
		ArrayList<DeltenPlayer> batmanes;
		ArrayList<DeltenPlayer> robines;
		int changes = sprintDays/pairDuration;
		JSONObject json = new JSONObject();
		json.put("datos", new JSONObject()
				.put("sprintDays", sprintDays)
				.put("pairDuration", pairDuration)
				.put("pairChanges", changes));
		try {
	    	batmanes = deltenPlayerDAO.findByBatman(true);
	    	robines = deltenPlayerDAO.findByBatman(false);
	    	for(int i=1; i<changes+1; i++){
	    		int count = 0;
	    		JSONObject pairs = new JSONObject();
	    		for (DeltenPlayer batman : batmanes) {
	    			pairs.put(batman.getName(), robines.get(count).getName());
	    			count++;
				}
	    		robines.add(0, robines.remove(count-1));
	    		json.put("pairing-"+i, pairs);
	    	}
	    }
	    catch (Exception ex) {
			return ex.getMessage() + ex.getStackTrace();
	    }

		return json.toString();
	}

	/**
	* /create_sprint  --> Return status
	* 
	* @return Status
	*/
	@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, value="/get_pairs", method = RequestMethod.POST)
	@ResponseBody
	public String createSprint(
		@RequestParam (value="startDate") String startDate,
		@RequestParam(value ="endDate") String endDate,
		@RequestParam(value ="listPlayers") ArrayList<DeltenPlayer> listPlayers,
		@RequestParam(value ="duration") int duration,
		@RequestParam(value ="holidayOnSite") int holidayOnSite
	) {
		
		return "";
	}
	
}