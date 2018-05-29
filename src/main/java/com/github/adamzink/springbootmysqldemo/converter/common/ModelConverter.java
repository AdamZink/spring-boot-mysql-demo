package com.github.adamzink.springbootmysqldemo.converter.common;

public interface ModelConverter<Q, M, S> {

    M requestToModel(Q request);

    S modelToResponse (M model);

}
