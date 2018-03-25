package com.guardian.app.service;

import com.guardian.app.domain.dto.UserDto;
import com.guardian.app.domain.entity.User;

import java.util.List;

public interface UserService {

    List<UserDto> findAll();

    UserDto findById(int id);

    void save(User user);

    void update(User user);

    List<UserDto> findUsers(User user);
}
