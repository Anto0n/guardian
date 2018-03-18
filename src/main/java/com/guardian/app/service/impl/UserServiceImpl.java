package com.guardian.app.service.impl;

import com.guardian.app.dao.UserDao;
import com.guardian.app.domain.dto.UserDto;
import com.guardian.app.domain.entity.User;
import com.guardian.app.service.UserService;
import com.guardian.app.util.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public UserDto findById(int id) {
        return UserUtil.toDto(userDao.findById(id));
    }

    @Override
    public void save(User user) {
        userDao.save(user);
    }
}
