package com.garden.coffee.coffeegarden.service;


import com.garden.coffee.coffeegarden.entity.Product;
import com.garden.coffee.coffeegarden.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;


    public Product save(String name, Long price){
        return productRepository.save(name,price);
    }

    public ArrayList<Product> search(Long productId){
        return productRepository.search(productId);
    }
}
