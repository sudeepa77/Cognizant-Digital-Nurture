package com.cognizant.userservice.service;

import com.cognizant.userservice.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public User getUser(int id) {

        return new User(
                id,
                "Sudeepa",
                "sudeepa@gmail.com"
        );

    }

}