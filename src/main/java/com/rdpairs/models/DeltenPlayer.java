package com.rdpairs.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "player")
public class DeltenPlayer {

	//Attributes
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id_player;
	
	@NotNull
	private String name;
	
	@NotNull
	private String email;
	
	@NotNull
	private boolean batman;
	
	
	//Constructors

	public DeltenPlayer() {
	}

	public DeltenPlayer(int id_player) {
		this.id_player = id_player;
	}

	public DeltenPlayer(String name, String email) {
		this.name = name;
		this.email = email;
	}

	//Getters & Setters

	public long getIdPlayer() {
		return id_player;
	}

	public void setIdPlayer(int id_player) {
		this.id_player = id_player;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isBatman() {
		return batman;
	}

	public void setBatman(boolean is_batman) {
		this.batman = is_batman;
	}
	
}