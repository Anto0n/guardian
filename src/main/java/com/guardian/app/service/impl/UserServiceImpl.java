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

import static com.guardian.app.util.DtoUtil.applyIfNotNullOrTrue;

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
    public List<UserDto> findUsers(User user) {

        List<UserDto> founded = userDao.findAllByFirstNameAndBirthDate(user.getFirstName(), user.getBirthDate())
                .stream()
                .map(DtoUtil::toDto)
                .filter(u -> applyIfNotNullOrTrue(user.getCitizenship(), citizenship -> DtoUtil.toDto(citizenship).equals(u.getCitizenship())))
//                .filter(u2 -> applyIfNotNullOrTrue(u2.getCity(), cityDto -> cityDto.equals(applyIfNotNull(user.getCity(), DtoUtil::toDto))))
//                .filter(u3 -> applyIfNotNullOrTrue(u3.getDepartment(), departmentDto -> departmentDto.equals(applyIfNotNull(user.getDepartment(), DtoUtil::toDto))))
//                .filter(u4 -> applyIfNotNullOrTrue(u4.getInn(), inn -> inn.equals(user.getInn())))
                .filter(u5 -> applyIfNotNullOrTrue(u5.getTel(), tel -> tel.equals(user.getTel())))
                .collect(Collectors.toList());

        return founded;
    }

    @Override
    public List<UserDto> findAll() {
        return userDao.findAll().stream().map(DtoUtil::toDto).collect(Collectors.toList());
    }
}
