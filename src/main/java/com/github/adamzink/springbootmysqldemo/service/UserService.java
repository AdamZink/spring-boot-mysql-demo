package com.github.adamzink.springbootmysqldemo.service;

import com.github.adamzink.springbootmysqldemo.model.db.UserModel;
import com.github.adamzink.springbootmysqldemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public UserModel save(final UserModel userModel) {
        userModel.setAddTs(new Date());

        return userRepository.save(userModel);
    }

}

