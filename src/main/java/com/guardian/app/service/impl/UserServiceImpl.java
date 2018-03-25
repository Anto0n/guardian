package com.guardian.app.service.impl;

import com.guardian.app.dao.UserDao;
import com.guardian.app.domain.dto.UserDto;
import com.guardian.app.domain.entity.User;
import com.guardian.app.service.UserService;
import com.guardian.app.util.DtoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public UserDto findById(int id) {
        return DtoUtil.toDto(userDao.findById(id));
    }

    @Override
    public void save(User user) {
        userDao.save(user);
    }

    @Override
    public void update(User user) {
        userDao.save(user);
    }

    @Override
    public List<UserDto> findAll() {
        return userDao.findAll().stream().map(DtoUtil::toDto).collect(Collectors.toList());
    }
}
