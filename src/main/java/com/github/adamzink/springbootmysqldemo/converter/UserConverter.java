package com.github.adamzink.springbootmysqldemo.converter;

import com.github.adamzink.springbootmysqldemo.converter.common.ModelConverter;
import com.github.adamzink.springbootmysqldemo.model.client.User;
import com.github.adamzink.springbootmysqldemo.model.db.UserModel;
import com.github.adamzink.springbootmysqldemo.model.client.UserRequest;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;

@Component
public class UserConverter implements ModelConverter<UserRequest, UserModel, User> {

    @Override
    public UserModel requestToModel(UserRequest request) {
        UserModel model = new UserModel();
        model.setFirstName(request.getFirstName());
        model.setLastName(request.getLastName());
        return model;
    }

    @Override
    public User modelToResponse(UserModel model) {
        User response = new User();
        response.setId(model.getId());
        response.setFirstName(model.getFirstName());
        response.setLastName(model.getLastName());
        response.setAddDate(new SimpleDateFormat("MMM d, yyyy").format(model.getAddTimestamp()));
        return response;
    }

}
