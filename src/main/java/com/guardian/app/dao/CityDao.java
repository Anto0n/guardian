package com.guardian.app.dao;

import com.guardian.app.domain.entity.City;
import org.springframework.data.repository.CrudRepository;

public interface CityDao extends CrudRepository<City, Integer> {
    City findById(int id);
}
