package com.garden.coffee.coffeegarden;

import java.security.NoSuchAlgorithmException;

public interface DataTransferObject<E>{
    E toEntity() throws NoSuchAlgorithmException;
}
