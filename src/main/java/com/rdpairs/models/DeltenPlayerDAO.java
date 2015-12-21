package com.rdpairs.models;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

@Transactional
public interface DeltenPlayerDAO extends CrudRepository<DeltenPlayer, Long> {
	
	public ArrayList<DeltenPlayer> findAll();
}