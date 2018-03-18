package com.guardian.app.dao;

import com.guardian.app.domain.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserDao extends CrudRepository<User, Integer> {
    User findById(int id);
    User save(User user);
}
