package com.garden.coffee.coffeegarden.order;

import com.garden.coffee.coffeegarden.DtoList;
import com.garden.coffee.coffeegarden.response.Response;
import com.garden.coffee.coffeegarden.response.ResponseDto;
import com.garden.coffee.coffeegarden.response.ResponseStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping("")
    public Response<DtoList<OrderDto>> search(){
        DtoList<OrderDto> allOrders = orderService.getAllOrders();
        ResponseStatus responseStatus = ResponseStatus.OK;
        if(allOrders == null){
            responseStatus = ResponseStatus.NOT_FOUND;
        }
        return new ResponseDto<DtoList<OrderDto>>(responseStatus,allOrders).toResponse();
    }
    @GetMapping("/id")
    public Response<OrderDto> searchByID(@RequestParam("query")String orderId){
        OrderDto searchedOrder = orderService.getOrder(orderId);
        ResponseStatus responseStatus = ResponseStatus.OK;
        if(searchedOrder == null){
            responseStatus = ResponseStatus.NOT_FOUND;
        }
        return new ResponseDto<OrderDto>(responseStatus, searchedOrder).toResponse();
    }

    @PostMapping("")
    public Response<OrderDto> placeOrder(@RequestBody OrderDto orderDto){
        OrderDto createdOrder = orderService.createOrder(orderDto);
        ResponseStatus responseStatus = ResponseStatus.CREATE_DONE;
        if(createdOrder == null){
            responseStatus = ResponseStatus.CREATE_FAIL;
        }
        return new ResponseDto<OrderDto>(responseStatus,createdOrder).toResponse();
    }

    @DeleteMapping("id")
    public Response<OrderDto> cancelById(@RequestParam("query") String orderId){
        OrderDto canceledOrder = orderService.deleteOrder(orderId);
        ResponseStatus responseStatus = ResponseStatus.OK;
        if(canceledOrder == null){
            responseStatus = ResponseStatus.NOT_FOUND;
        }
        return new ResponseDto<OrderDto>(responseStatus,canceledOrder).toResponse();
    }

    @DeleteMapping("")
    public Response<DtoList<OrderDto>> cancelAll(){
        DtoList<OrderDto> allCanceledOrder = orderService.deleteAllOrder();
        ResponseStatus responseStatus = ResponseStatus.OK;
        if(allCanceledOrder == null){
            responseStatus = ResponseStatus.NOT_FOUND;
        }
        return new ResponseDto<DtoList<OrderDto>>(responseStatus,allCanceledOrder).toResponse();
    }
}
