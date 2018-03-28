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

        List<UserDto> founded = userDao.findAllByFirstNameAndBirthDate(user.getFirstName(), user.getBirthDate().replace(".", ""))
                .stream()
                .filter(e-> this.filterWithUser(user, e))
                .map(DtoUtil::toDto)
//                .filter(u -> applyIfNotNullOrTrue(user.getCitizenship(), citizenship -> DtoUtil.toDto(citizenship).equals(u.getCitizenship())))
//                .filter(u2 -> applyIfNotNullOrTrue(user.getCity(), city -> DtoUtil.toDto(city).equals(u2.getCity())))
//                .filter(u3 -> applyIfNotNullOrTrue(user.getDepartment(), department -> DtoUtil.toDto(department).equals(u3.getDepartment())))
//                .filter(u4 -> applyIfNotNullOrTrue(user.getInn(), inn -> inn.equals(u4.getInn())))
//                .filter(u5 -> applyIfNotNullOrTrue(user.getTel(), tel -> tel.equals(u5.getTel())))
                .collect(Collectors.toList());

        return founded;
    }

    @Override
    public List<UserDto> findAll() {
        return userDao.findAll().stream().map(DtoUtil::toDto).collect(Collectors.toList());
    }

    private boolean filterWithUser(User initUser, User dbUser) {
        return applyIfNotNullOrTrue(initUser.getCitizenship(), citizenship -> citizenship.getCitizenship().equals(dbUser.getCitizenship().getCitizenship()))
                &&  applyIfNotNullOrTrue(initUser.getCity(), city -> city.getCity().equals(dbUser.getCity().getCity()))
                && applyIfNotNullOrTrue(initUser.getDepartment(), department -> department.getDepartment().equals(dbUser.getDepartment().getDepartment()))
                && applyIfNotNullOrTrue(initUser.getInn(), inn -> inn.equals(dbUser.getInn()))
                && applyIfNotNullOrTrue(initUser.getTel(), tel -> tel.equals(dbUser.getTel()));
    }
}
