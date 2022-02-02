package com.kata.spring.bootstrap.spring_bootstrap.service;



import com.kata.spring.bootstrap.spring_bootstrap.model.User;
import javassist.NotFoundException;

import java.util.List;

public interface UserService {
    List<User> allUsers();

    void saveUser(User user);

    User getById(long id);

    void update(User user);

    void delete(long id);

    User getByEmail(String email) throws NotFoundException;
}
