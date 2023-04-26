package com.garden.coffee.coffeegarden.order;

import lombok.Getter;

@Getter
public enum OrderState {
    PLACED("주문 완료"),
    CONFIRMED("주문 확인"),
    IN_TRANSIT("배송 중"),
    DELIVERED("배송 완료"),
    CANCELLED("주문 취소"),
    REFUNDED("환불 완료"),
    FAILED("주문 실패");

    private final String orderState;

    OrderState(String state) {
        this.orderState = state;
    }

}
