package com.guardian.app.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.guardian.app.domain.entity.City;

public interface CityDao extends CrudRepository<City, Integer> {
    City findById(int id);
    City save(City city);
    List<City> findAll();
}
