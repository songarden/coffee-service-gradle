package com.garden.coffee.coffeegarden.order;

import com.garden.coffee.coffeegarden.DtoList;
import com.garden.coffee.coffeegarden.response.Response;
import com.garden.coffee.coffeegarden.response.ResponseDto;
import com.garden.coffee.coffeegarden.response.ResponseStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping("/orders")
    public Response<DtoList<OrderDto>> apiGetAllOrders(){
        DtoList<OrderDto> allOrders = orderService.getAllOrders();
        ResponseStatus responseStatus = ResponseStatus.OK;
        if(allOrders == null){
            responseStatus = ResponseStatus.NOT_FOUND;
        }
        return new ResponseDto<DtoList<OrderDto>>(responseStatus,allOrders).toResponse();
    }
    @GetMapping("/orders/order-id")
    public Response<OrderDto> apiGetOrderByOrderID(@RequestParam("v")String orderId){
        OrderDto searchedOrder = orderService.getOrder(orderId);
        ResponseStatus responseStatus = ResponseStatus.OK;
        if(searchedOrder == null){
            responseStatus = ResponseStatus.NOT_FOUND;
        }
        return new ResponseDto<OrderDto>(responseStatus, searchedOrder).toResponse();
    }

    @PostMapping("/orders")
    public Response<OrderDto> apiCreateOrder(@RequestBody OrderDto orderDto){
        OrderDto createdOrder = orderService.createOrder(orderDto);
        ResponseStatus responseStatus = ResponseStatus.CREATE_DONE;
        if(createdOrder == null){
            responseStatus = ResponseStatus.CREATE_FAIL;
        }
        return new ResponseDto<OrderDto>(responseStatus,createdOrder).toResponse();
    }

    @DeleteMapping("/orders/order-id")
    public Response<OrderDto> apiCancelOrder(@RequestParam String orderId){
        OrderDto canceledOrder = orderService.deleteOrder(orderId);
        ResponseStatus responseStatus = ResponseStatus.OK;
        if(canceledOrder == null){
            responseStatus = ResponseStatus.NOT_FOUND;
        }
        return new ResponseDto<OrderDto>(responseStatus,canceledOrder).toResponse();
    }

    @DeleteMapping("/orders")
    public Response<DtoList<OrderDto>> apiCancelAllOrders(){
        DtoList<OrderDto> allCanceledOrder = orderService.deleteAllOrder();
        ResponseStatus responseStatus = ResponseStatus.OK;
        if(allCanceledOrder == null){
            responseStatus = ResponseStatus.NOT_FOUND;
        }
        return new ResponseDto<DtoList<OrderDto>>(responseStatus,allCanceledOrder).toResponse();
    }
}
