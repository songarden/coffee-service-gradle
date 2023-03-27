package com.garden.coffee.coffeegarden.product;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {
    @Autowired
    ProductService productService;

    @PostMapping("/products")
    public Product apiSave(@RequestParam("name") String name, @RequestParam("price") Long price, @RequestParam("category")Category category,@RequestParam("sale")Long sale){
        Product product = new Product(name, price, category, sale);
        return productService.save(product);
    }

    @GetMapping("/products")
    public Product apiSearch(@RequestParam("product-id") Long productId){
        return productService.search(productId);
    }

    @DeleteMapping("/products")
    public Product apiDelete(@RequestParam("product-id") Long productId){
        return productService.delete(productId);
    }
}
