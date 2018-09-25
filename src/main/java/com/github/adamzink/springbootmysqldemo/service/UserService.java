package com.github.adamzink.springbootmysqldemo.service;

import com.github.adamzink.springbootmysqldemo.converter.UserConverter;
import com.github.adamzink.springbootmysqldemo.model.client.User;
import com.github.adamzink.springbootmysqldemo.model.client.UserRequest;
import com.github.adamzink.springbootmysqldemo.model.db.UserModel;
import com.github.adamzink.springbootmysqldemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.NotFoundException;
import java.util.Collection;
import java.util.Date;

@Service
@Transactional
public class UserService {

    @Autowired
    UserConverter userConverter;

    @Autowired
    UserRepository userRepository;

    public Collection<User> getAll() {
        return userConverter.modelToResponse(userRepository.findAll());
    }

    public User save(final UserRequest userRequest) {
        UserModel userModel = getValidatedRequestToModel(userRequest);

        userModel.setAddTs(new Date());

        return userConverter.modelToResponse(userRepository.save(userModel));
    }

    public User update(final Long id, final UserRequest userRequest) {
        UserModel toSave = userRepository.findById(id).orElseThrow(NotFoundException::new);

        UserModel fromRequest = getValidatedRequestToModel(userRequest);

        toSave.setFirstName(fromRequest.getFirstName());
        toSave.setLastName(fromRequest.getLastName());

        return userConverter.modelToResponse(userRepository.save(toSave));
    }

    public void delete(final Long id) {
        userRepository.findById(id).orElseThrow(NotFoundException::new);
        userRepository.deleteById(id);
    }

    private UserModel getValidatedRequestToModel(final UserRequest userRequest) {
        UserModel model = userConverter.requestToModel(userRequest);

        if (model.getFirstName() == null || model.getLastName() == null) {
            throw new BadRequestException();
        }

        return model;
    }

}

