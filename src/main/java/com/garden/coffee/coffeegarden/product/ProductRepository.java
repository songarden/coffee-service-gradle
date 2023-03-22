package com.garden.coffee.coffeegarden.product;


import com.garden.coffee.coffeegarden.product.Product;

public interface ProductRepository {

    abstract Product save(Product product);
    abstract Product search(Long productId);
}
