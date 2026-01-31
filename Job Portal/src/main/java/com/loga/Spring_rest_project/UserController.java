package com.loga.Spring_rest_project;


import com.loga.Spring_rest_project.model.User;
import com.loga.Spring_rest_project.service.JwtService;
import com.loga.Spring_rest_project.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private userService service;
    @Autowired
    private JwtService jwt;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/user/register")
    public User register(@RequestBody User user){
        service.saveUser(user);
        return user;
    }

    @PostMapping("/user/login")
    public String login(@RequestBody User user){
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken
                             (user.getUsername(), user.getPassword())
                );
        if(authentication.isAuthenticated())
            return jwt.generateToken(user.getUsername(), user.getRole());
        else
            return "Login Failed";
    }

}
