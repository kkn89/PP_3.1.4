package com.kata.spring.bootstrap.spring_bootstrap.service;



import com.kata.spring.bootstrap.spring_bootstrap.dao.UserRepository;
import com.kata.spring.bootstrap.spring_bootstrap.model.Role;
import com.kata.spring.bootstrap.spring_bootstrap.model.User;
import javassist.NotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {


    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    private BCryptPasswordEncoder bCrypt() {
        return new BCryptPasswordEncoder();
    }
    @Override

    public List<User> allUsers() {
        return userRepository.findAll();
    }

    @Override

    public void saveUser(User user) {
        user.setPassword(bCrypt().encode(user.getPassword()));
        userRepository.save(user);

    }

    @Override
    public User getById(long id) {
        User user = null;
        Optional<User> optional = userRepository.findById(id);
        if(optional.isPresent()){
            user = optional.get();
        }
        return user;
    }

    @Override
       public void update(User user) {
        user.setPassword(bCrypt().encode(user.getPassword()));
        userRepository.save(user);
    }

    @Override
       public void delete(long id) {
        userRepository.deleteById(id);

    }

    @Override
    public User getByEmail(String email) throws NotFoundException {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            throw new NotFoundException(email);
        }
        return user;
    }
}
