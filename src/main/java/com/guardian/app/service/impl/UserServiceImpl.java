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

        return userDao.findAllByFirstNameAndLastNameAndBirthDate(user.getFirstName(), user.getLastName(), user.getBirthDate().replace(".", ""))
                .stream()
                .filter(e-> this.filterWithUser(user, e))
                .map(DtoUtil::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<UserDto> findAll() {
        return userDao.findAll().stream().map(DtoUtil::toDto).collect(Collectors.toList());
    }

    private boolean filterWithUser(User initUser, User dbUser) {
        return applyIfNotNullOrTrue(initUser.getCitizenship().getCitizenship(), citizenship -> citizenship.equals(dbUser.getCitizenship().getCitizenship()))
                && applyIfNotNullOrTrue(initUser.getCity().getCity(), city -> city.equals(dbUser.getCity().getCity()))
                && applyIfNotNullOrTrue(initUser.getDepartment().getDepartment(), department -> department.equals(dbUser.getDepartment().getDepartment()))               && applyIfNotNullOrTrue(initUser.getInn(), inn -> inn.equals(dbUser.getInn()))
                && applyIfNotNullOrTrue(initUser.getTel(), tel -> tel.equals(dbUser.getTel()));
    }
}
