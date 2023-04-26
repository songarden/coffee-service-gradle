package com.garden.coffee.coffeegarden.order;

import com.garden.coffee.coffeegarden.DtoList;
import com.garden.coffee.coffeegarden.product.Product;
import com.garden.coffee.coffeegarden.product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;
    @Autowired
    ProductRepository productRepository;

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
        List<Product> products = new ArrayList<>();
        for(Product product : creatingOrder.getProducts()){
            Optional<Product> optProduct = productRepository.findByProductName(product.getProductName());
            if(optProduct.isEmpty()){
                return null;
            }
            products.add(optProduct.get());
        }
        creatingOrder.setProducts(products);

        creatingOrder.orderPrice = 0;
        int orderPriceSum = creatingOrder.orderPrice; //주문 상품들의 할인된 금액 합계 저장할 변수

        for(Product product : products){
            int productPrice = product.getProductPrice();
            int salePercent = product.getSalePercent();
            if(salePercent > 0){
                productPrice -= (productPrice * salePercent) / 100;
            }
            orderPriceSum += productPrice;
        } //Product에서 금액과 할인율을 받아 실제 금액을 계산한 후, 각각을 합계 변수에 금액 축적
        //한개의 주문에 여러개의 상품이 들어 있을 수도 있음 ( 장바구니 서비스 )

        creatingOrder.setOrderPrice(orderPriceSum);
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
