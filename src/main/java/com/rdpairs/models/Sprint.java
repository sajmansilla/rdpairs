package com.rdpairs.models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.rdpairs.models.DeltenPlayer;

public class Sprint {

	//Attributes
	private Date startDate;
	private Date endDate;
	private ArrayList<DeltenPlayer> listPlayers;
	private int duration;
	private int holidayOnSite;

	//Contructur
	public Sprint(String startDate, String endDate,ArrayList<DeltenPlayer> listPlayers, int duration, int holidayOnSite) {
		this.setStartDate(this.createCorrectDate(startDate));
		this.setEndDate(this.createCorrectDate(endDate));
		this.setListPlayers(listPlayers);
		this.setDuration(duration);
		this.setHolidayOnSite(holidayOnSite);
	}

	//getters and setters
	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public ArrayList<DeltenPlayer> getListPlayers() {
		return listPlayers;
	}

	public void setListPlayers(ArrayList<DeltenPlayer> listPlayers) {
		this.listPlayers = listPlayers;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public int getHolidayOnSite() {
		return holidayOnSite;
	}

	public void setHolidayOnSite(int holidayOnSite) {
		this.holidayOnSite = holidayOnSite;
	}

	private Date createCorrectDate(String stringDate) {
		Date correctDate = null;
		SimpleDateFormat formatDay = new SimpleDateFormat("yyyy-MM-dd");

		try {
			correctDate = formatDay.parse(stringDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return correctDate;
	}

}
