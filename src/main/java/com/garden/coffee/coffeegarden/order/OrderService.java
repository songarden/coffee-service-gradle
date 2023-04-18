package com.garden.coffee.coffeegarden.order;

import com.garden.coffee.coffeegarden.DtoList;
import com.garden.coffee.coffeegarden.product.Product;
import com.garden.coffee.coffeegarden.product.ProductDto;
import com.garden.coffee.coffeegarden.product.ProductJPARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;
    @Autowired
    ProductJPARepository productRepository;

    public DtoList<OrderDto> getAllOrders() {
        DtoList<OrderDto> allOrders = new DtoList<>(orderRepository.findAll());
        return allOrders;
    }

    public OrderDto getOrder(String orderId) {
        Optional<Order> optGetOrder = orderRepository.findById(orderId);
        if(optGetOrder.isEmpty()){
            return null;
        }
        OrderDto gettingOrder = new OrderDto(optGetOrder.get());
        return gettingOrder;
    }

    public OrderDto createOrder(OrderDto orderDto) {
        OrderDto creatingOrder = orderDto;
        Optional<Product> optOrderedProduct = productRepository.findByProductName(creatingOrder.productName);
        if(optOrderedProduct.isEmpty()){
            return null;
        }
        ProductDto orderedProduct = new ProductDto(optOrderedProduct.get());
        int discountedPrice = orderedProduct.getProductPrice();
        int salePercent = orderedProduct.getSalePercent();
        if (salePercent > 0) {
            discountedPrice -= (discountedPrice * salePercent) / 100;
        }
        creatingOrder.setOrderPrice(discountedPrice);
        creatingOrder.setOrderId(UUID.randomUUID().toString().replace("-",""));
        creatingOrder.setOrderTime(LocalDateTime.now());
        creatingOrder.setOrderState(OrderState.PLACED);

        orderRepository.save(creatingOrder.toEntity());
        return creatingOrder;
    }

    public OrderDto deleteOrder(String orderId) {
        Optional<Order> optDeleteOrder = orderRepository.findById(orderId);
        if(optDeleteOrder.isEmpty()){
            return null;
        }
        OrderDto deletingOrder = new OrderDto(optDeleteOrder.get());
        orderRepository.deleteById(orderId);
        return deletingOrder;
    }

    public DtoList<OrderDto> deleteAllOrder() {
        DtoList<OrderDto> allDeletingOrder = new DtoList<>(orderRepository.findAll());
        orderRepository.deleteAll();
        return allDeletingOrder;
    }
}
