package com.kata.spring.bootstrap.spring_bootstrap.service;



import com.kata.spring.bootstrap.spring_bootstrap.model.User;
import javassist.NotFoundException;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> getAllUsers();

    void addUser(User user);

    void updateUser(User user);

    void deleteUserById(long id);

    User getUser(long id);

    Optional<User> getUserById(long id);

    User getByUsername(String username);
}
