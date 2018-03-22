package com.guardian.app.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.guardian.app.dao.CityDao;
import com.guardian.app.domain.dto.CityDto;
import com.guardian.app.domain.entity.City;
import com.guardian.app.service.CityService;
import com.guardian.app.util.DtoUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityDao cityDao;

    @Override
    public List<CityDto> findAll() {
        return cityDao.findAll().stream().map(DtoUtil::toDto).collect(Collectors.toList());
    }

    @Override
    public CityDto findById(int id) {
        return DtoUtil.toDto(cityDao.findById(id));
    }

    @Override
    public void save(City city) {
        cityDao.save(city);
    }

    @Override
    public void update(City city) {
        cityDao.save(city);
    }
}
