package com.guardian.app.dao;

import com.guardian.app.domain.entity.User;
import com.sun.istack.internal.NotNull;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

import lombok.NonNull;

public interface UserDao extends CrudRepository<User, Integer> {
    User findById(int id);
    User save(User user);
    List<User> findAll();
    List<User> findAllByFirstNameAndBirthDate(String firstName, String birthDate);
}
