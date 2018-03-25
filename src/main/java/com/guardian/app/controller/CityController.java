package com.guardian.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.guardian.app.domain.dto.CityDto;
import com.guardian.app.service.CityService;

@RestController
public class CityController {

    @Autowired
    private CityService cityService;

    @GetMapping(value = "/get")
    public CityDto getCityById() {
        return cityService.findById(1);
    }
}
