package com.guardian.app.controller;

import com.guardian.app.domain.dto.UserDto;
import com.guardian.app.domain.entity.User;
import com.guardian.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/user2")
    public UserDto getUser() {
        return userService.findById(2);
    }

    @PostMapping(value = "/find", consumes = "application/json")
    public List<UserDto> findUsers(@RequestBody User user) {
        return userService.findUsers(user);
    }


    @PostMapping(value = "/put")
    public void getUser(User user) {
        userService.save(user);
    }

    @GetMapping(value = "/all")
    public List<UserDto> getUsers() {
        return userService.findAll();
    }
}
