package com.guardian.app.service;

import com.guardian.app.domain.dto.UserDto;
import com.guardian.app.domain.entity.User;

public interface UserService {
    UserDto findById(int id);

    void save(User user);
}
