package com.loga.Spring_rest_project.dao;


import com.loga.Spring_rest_project.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepo extends JpaRepository<User,Integer> {

    User findByUsername(String Username);

}
