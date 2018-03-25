package com.guardian.app.dao;

import java.util.List;

import com.guardian.app.domain.entity.Photo;

public interface PhotoDao {
	Photo findById(int id);
	Photo save(Photo photo);
	List<Photo> findAll();
}
