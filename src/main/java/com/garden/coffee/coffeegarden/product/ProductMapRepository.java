package com.garden.coffee.coffeegarden.product;


import com.garden.coffee.coffeegarden.product.Product;
import com.garden.coffee.coffeegarden.product.ProductRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class ProductMapRepository implements ProductRepository {

    Map<Long,Product> db = new HashMap<>();
    Long productId = 1L;

    @Override
    public Product save(Product product) {
        db.put(productId,product);
        productId++;
        return product;
    }

    @Override
    public Product search(Long productId) {
        Product product = db.get(productId);
        return product;
    }
}
