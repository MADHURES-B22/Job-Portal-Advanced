package com.loga.Spring_rest_project.service;


import com.loga.Spring_rest_project.dao.UserRepo;
import com.loga.Spring_rest_project.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class userService {

    @Autowired
    private UserRepo repo;
    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
    public User saveUser(User user) {
        user.setPassword(encoder.encode(user.getPassword()));//Encoding
        return repo.save(user);
    }


}
