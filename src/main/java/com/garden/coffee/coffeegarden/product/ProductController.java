package com.garden.coffee.coffeegarden.product;


import com.garden.coffee.coffeegarden.DtoList;
import com.garden.coffee.coffeegarden.response.Response;
import com.garden.coffee.coffeegarden.response.ResponseDto;
import com.garden.coffee.coffeegarden.response.ResponseStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("/products")
    public Response<DtoList<ProductDto>> apiSearchAll(){
        DtoList<ProductDto> searchingProductList = productService.getAllProduct();
        ResponseStatus responseStatus = ResponseStatus.CREATE_DONE;
        if(searchingProductList == null){
            responseStatus = ResponseStatus.CREATE_FAIL;
        }
        return new ResponseDto<DtoList<ProductDto>>(responseStatus,searchingProductList).toResponse();
    }

    @GetMapping("/products/product-id")
    public Response<ProductDto> apiSearch(@RequestParam("v") String productId){
        ProductDto searchingProduct = productService.getProduct(productId);
        ResponseStatus responseStatus = ResponseStatus.CREATE_DONE;
        if(searchingProduct == null){
            responseStatus = ResponseStatus.CREATE_FAIL;
        }
        return new ResponseDto<ProductDto>(responseStatus,searchingProduct).toResponse();
    }
    @PostMapping("/products")
    public Response<ProductDto> apiSave(@RequestBody ProductDto productDto){
        ProductDto savingProduct = productService.save(productDto);
        ResponseStatus responseStatus = ResponseStatus.CREATE_DONE;
        if(savingProduct == null){
            responseStatus = ResponseStatus.CREATE_FAIL;
        }
        return new ResponseDto<ProductDto>(responseStatus,savingProduct).toResponse();
    }

    @DeleteMapping("/products/product-id")
    public Response<ProductDto> apiDelete(@RequestParam("v") String productId){
        ProductDto deletingProduct = productService.deleteProduct(productId);
        ResponseStatus responseStatus = ResponseStatus.CREATE_DONE;
        if(deletingProduct == null){
            responseStatus = ResponseStatus.CREATE_FAIL;
        }
        return new ResponseDto<ProductDto>(responseStatus,deletingProduct).toResponse();
    }
}
