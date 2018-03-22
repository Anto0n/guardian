package com.guardian.app.service;

import java.util.List;

import com.guardian.app.domain.dto.CityDto;
import com.guardian.app.domain.entity.City;

public interface CityService {

    List<CityDto> findAll();

    CityDto findById(int id);

    void save(City city);

    void update(City city);
}
