package com.rdpairs.controllers;

import com.rdpairs.dao.DeltenPlayerDAO;
import com.rdpairs.models.DeltenPlayer;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DeltenPlayerController {
	
	@Autowired
	private DeltenPlayerDAO deltenPlayerDAO;
  
	/**
	* /get-players  --> Return all the players
	* 
	* @return The players on the DB.
	*/
	@RequestMapping("/get-players")
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
	
}