package com.garden.coffee.coffeegarden.product;


import com.garden.coffee.coffeegarden.product.Product;
import com.garden.coffee.coffeegarden.product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public Product save(Product product){
        return productRepository.save(product);
    }

    public Product search(Long productId){
        return productRepository.search(productId);
    }
}
