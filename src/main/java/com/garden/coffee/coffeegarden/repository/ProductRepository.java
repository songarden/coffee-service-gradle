package com.garden.coffee.coffeegarden.repository;


import com.garden.coffee.coffeegarden.entity.Product;

import java.util.ArrayList;

public interface ProductRepository {

    abstract Product save(String name, Long price);
    abstract ArrayList<Product> search(Long productId);
}
