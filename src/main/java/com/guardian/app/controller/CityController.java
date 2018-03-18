package com.guardian.app.controller;

import com.guardian.app.domain.entity.City;
import com.guardian.app.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CityController {

    @Autowired
    private CityService cityService;

    @GetMapping(value = "/get")
    public City getCityById() {
        return cityService.getCityById(1);
    }
}
