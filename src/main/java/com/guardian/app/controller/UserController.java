package com.guardian.app.controller;

import com.guardian.app.domain.dto.UserDto;
import com.guardian.app.domain.entity.User;
import com.guardian.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/user2")
    public UserDto getUser() {
        return userService.findById(2);
    }

    @PostMapping(value = "/put")
    public void getUser(User user) {
        userService.save(user);
    }
}
