package com.garden.coffee.coffeegarden;

import com.garden.coffee.coffeegarden.response.Response;
import com.garden.coffee.coffeegarden.response.ResponseStatus;
import com.garden.coffee.coffeegarden.response.Responseable;
import lombok.NoArgsConstructor;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.IntFunction;
import java.util.stream.Stream;

@NoArgsConstructor
public class DtoList<E> extends ArrayList implements DataTransferObject, Responseable {
    public <T> DtoList (List<T> anyList){
        for (T elem : anyList){
            this.add(elem);
        }
    }


    @Override
    public Object toEntity() throws NoSuchAlgorithmException {
        return null;
    }

    @Override
    public DataTransferObject toDto(Object entity) {
        return null;
    }

    @Override
    public Response toResponse(ResponseStatus responseStatus) {
        return Responseable.super.toResponse(responseStatus);
    }

    public Response toResponse() {
        return Responseable.super.toResponse();
    }

    @Override
    public Object[] toArray(IntFunction generator) {
        return super.toArray(generator);
    }

    @Override
    public Stream stream() {
        return super.stream();
    }

    @Override
    public Stream parallelStream() {
        return super.parallelStream();
    }
}
