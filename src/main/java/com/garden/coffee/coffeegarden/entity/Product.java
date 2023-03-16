package com.garden.coffee.coffeegarden.entity;



public class Product {
    public String name;
    public Long price;
    public Category category;
    public Long sale;

    public Product(String name, Long price, Category category, Long sale) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.sale = sale;
    }
}
