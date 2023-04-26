package com.garden.coffee.coffeegarden.order;


import com.garden.coffee.coffeegarden.product.Product;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name="orders")
@Getter
@NoArgsConstructor
@Data
public class Order {

    @Id
    @Column(name="order_id")
    private String orderId;

    @Column(name="order_price")
    private int orderPrice;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Product> products = new ArrayList<>();

    @Column(name="address")
    private String address;

    @Column(name="order_time")
    private LocalDateTime orderTime;

    @Column(name="order_state")
    private OrderState orderState;

    @Builder
    public Order(String orderId, int orderPrice, List<Product> products, String address, LocalDateTime orderTime, OrderState orderState) {
        this.orderId = orderId;
        this.orderPrice = orderPrice;
        this.products = products;
        this.address = address;
        this.orderTime = orderTime;
        this.orderState = orderState;
    }
}
