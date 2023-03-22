package com.garden.coffee.coffeegarden.repository;


import com.garden.coffee.coffeegarden.entity.Product;

import java.util.ArrayList;

public interface ProductRepository {

    abstract Product save(Product product);
    abstract ArrayList<Product> search(Long productId);
}
