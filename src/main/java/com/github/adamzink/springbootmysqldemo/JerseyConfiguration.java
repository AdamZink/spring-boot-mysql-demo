package com.github.adamzink.springbootmysqldemo;

import com.github.adamzink.springbootmysqldemo.resource.UserResource;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

@Component
public class JerseyConfiguration extends ResourceConfig {

    public JerseyConfiguration() {
        register(UserResource.class);
    }

}
