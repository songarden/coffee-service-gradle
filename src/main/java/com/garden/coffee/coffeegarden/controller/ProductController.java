package com.garden.coffee.coffeegarden.controller;


import com.garden.coffee.coffeegarden.entity.Product;
import com.garden.coffee.coffeegarden.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class ProductController {
    @Autowired
    ProductService productService;

    @RequestMapping("/save")
    public Product save(@RequestParam("name") String name, @RequestParam("price") Long price){
        return productService.save(name,price);
    }

    @RequestMapping("/search")
    public ArrayList<Product> search(@RequestParam("product-id") Long productId){
        return productService.search(productId);
    }
}
