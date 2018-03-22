package com.guardian.app.dao;

import java.util.List;

import com.guardian.app.domain.entity.Citizenship;

public interface CitizenshipDao {
	Citizenship findById(int id);
	Citizenship save(Citizenship citizenship);
	List<Citizenship> findAll();
}
