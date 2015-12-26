package com.rdpairs.dao;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.rdpairs.models.DeltenPlayer;

@Transactional
public interface DeltenPlayerDAO extends CrudRepository<DeltenPlayer, Long> {
	
	public ArrayList<DeltenPlayer> findAll();
}