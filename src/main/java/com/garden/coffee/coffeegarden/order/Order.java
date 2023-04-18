package com.garden.coffee.coffeegarden.order;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


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

    @Column(name="product_name")
    private String productName;

    @Column(name="address")
    private String address;

    @Column(name="order_time")
    private LocalDateTime orderTime;

    @Column(name="order_state")
    private OrderState orderState;

    @Builder
    public Order(String orderId, int orderPrice, String productName, String address, LocalDateTime orderTime, OrderState orderState) {
        this.orderId = orderId;
        this.orderPrice = orderPrice;
        this.productName = productName;
        this.address = address;
        this.orderTime = orderTime;
        this.orderState = orderState;
    }
}
