package com.garden.coffee.coffeegarden.product;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {
    @Autowired
    ProductService productService;

    @PostMapping("/save")
    public Product save(@RequestParam("name") String name, @RequestParam("price") Long price, @RequestParam("category")Category category,@RequestParam("sale")Long sale){
        Product product = new Product(name, price, category, sale);
        return productService.save(product);
    }

    @GetMapping("/search")
    public Product search(@RequestParam("product-id") Long productId){
        return productService.search(productId);
    }
}
