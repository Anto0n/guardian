package com.guardian.app.service.impl;

import com.guardian.app.dao.CityDao;
import com.guardian.app.domain.entity.City;
import com.guardian.app.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityDao cityDao;

    @Override
    public City getCityById(int id) {
        return cityDao.findById(id);
    }
}
