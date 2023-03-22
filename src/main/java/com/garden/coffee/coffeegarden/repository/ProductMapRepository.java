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
    public Product save(Product product) {
        db.put(productId,new ArrayList<>());
        db.get(productId).add(product);
        productId++;
        return product;
    }

    @Override
    public ArrayList<Product> search(Long productId) {
        ArrayList<Product> product = db.get(productId);
        return product;
    }
}
