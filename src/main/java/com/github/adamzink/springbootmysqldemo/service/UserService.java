package com.github.adamzink.springbootmysqldemo.service;

import com.github.adamzink.springbootmysqldemo.converter.UserConverter;
import com.github.adamzink.springbootmysqldemo.model.client.User;
import com.github.adamzink.springbootmysqldemo.model.client.UserRequest;
import com.github.adamzink.springbootmysqldemo.model.db.UserModel;
import com.github.adamzink.springbootmysqldemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
@Transactional
public class UserService {

    @Autowired
    UserConverter userConverter;

    @Autowired
    UserRepository userRepository;

    public User save(final UserRequest userRequest) {
        UserModel userModel = userConverter.requestToModel(userRequest);

        userModel.setAddTs(new Date());

        return userConverter.modelToResponse(userRepository.save(userModel));
    }

}

