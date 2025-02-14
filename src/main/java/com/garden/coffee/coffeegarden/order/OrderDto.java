package com.garden.coffee.coffeegarden.order;

import com.garden.coffee.coffeegarden.DataTransferObject;
import com.garden.coffee.coffeegarden.product.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class OrderDto implements DataTransferObject<Order> {

    public String orderId;
    public int orderPrice;
    public List<Product> products;
    public String address;
    public LocalDateTime orderTime;
    public OrderState orderState;

    public OrderDto(String orderId, int orderPrice, List<Product> products, String address, LocalDateTime orderTime, OrderState orderState) {
        this.orderId = orderId;
        this.orderPrice = orderPrice;
        this.products = products;
        this.address = address;
        this.orderTime = orderTime;
        this.orderState = orderState;
    }

    public OrderDto(Order order){
        this.orderId = order.getOrderId();
        this.orderPrice = order.getOrderPrice();
        this.products = order.getProducts();
        this.address = order.getAddress();
        this.orderTime = order.getOrderTime();
        this.orderState = order.getOrderState();
    }

    @Override
    public Order toEntity()  {
        return Order.builder().orderId(this.orderId).orderPrice(this.orderPrice).products(this.products).address(this.address).orderState(this.orderState).orderTime(this.orderTime).build();
    }

}
