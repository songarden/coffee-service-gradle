package com.garden.coffee.coffeegarden.repository;


import com.garden.coffee.coffeegarden.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;

@Repository
public class ProductMapRepository implements ProductRepository{

    HashMap<Long, ArrayList<Product>> db = new HashMap<>();
    Long productId = 1L;

    @Override
    public Product save(String name, Long price) {
        Product product = new Product(name,price);
        db.put(productId++,new ArrayList<>());
        db.get(productId-1).add(product);
        return product;
    }

    @Override
    public ArrayList<Product> search(Long productId) {
        ArrayList<Product> product = db.get(productId);
        return product;
    }
}
