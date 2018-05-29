package com.github.adamzink.springbootmysqldemo.facade;

import com.github.adamzink.springbootmysqldemo.converter.UserConverter;
import com.github.adamzink.springbootmysqldemo.model.client.User;
import com.github.adamzink.springbootmysqldemo.model.client.UserRequest;
import com.github.adamzink.springbootmysqldemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserFacade {

    @Autowired
    UserConverter userConverter;

    @Autowired
    UserService userService;

    public User save(UserRequest userRequest) {
        return userConverter.modelToResponse(
                userService.save(userConverter.requestToModel(userRequest))
        );
    }

}
