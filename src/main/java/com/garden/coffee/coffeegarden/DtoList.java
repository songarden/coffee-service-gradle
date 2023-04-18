package com.garden.coffee.coffeegarden;

import com.garden.coffee.coffeegarden.response.Response;
import com.garden.coffee.coffeegarden.response.Responseable;
import lombok.NoArgsConstructor;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
public class DtoList<E> extends ArrayList implements DataTransferObject, Responseable{
    public <T> DtoList (List<T> anyList){
        for (T elem : anyList){
            this.add(elem);
        }
    }

    @Override
    public Object toEntity() throws NoSuchAlgorithmException {
        return null;
    }

    public Response toResponse() {
        return Responseable.super.toResponse();
    }

}
