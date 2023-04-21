package com.garden.coffee.coffeegarden.product;


import com.garden.coffee.coffeegarden.DtoList;
import com.garden.coffee.coffeegarden.response.Response;
import com.garden.coffee.coffeegarden.response.ResponseDto;
import com.garden.coffee.coffeegarden.response.ResponseStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("") //모든 상품 조회
    public Response<DtoList<ProductDto>> Search(){
        DtoList<ProductDto> searchingProductList = productService.getAllProduct();
        ResponseStatus responseStatus = ResponseStatus.CREATE_DONE;
        if(searchingProductList == null){
            responseStatus = ResponseStatus.CREATE_FAIL;
        }
        return new ResponseDto<DtoList<ProductDto>>(responseStatus,searchingProductList).toResponse();
    }

    @GetMapping("/id") //PK로 상품 조회
    public Response<ProductDto> searchById(@RequestParam("query") String productId){
        ProductDto searchingProduct = productService.getProduct(productId);
        ResponseStatus responseStatus = ResponseStatus.CREATE_DONE;
        if(searchingProduct == null){
            responseStatus = ResponseStatus.CREATE_FAIL;
        }
        return new ResponseDto<ProductDto>(responseStatus,searchingProduct).toResponse();
    }

    @GetMapping("/name")
    public Response<ProductDto> searchByName(@RequestParam("query") String productName){
        ProductDto searchingProductName = productService.getProductByProductName(productName);
        ResponseStatus responseStatus = ResponseStatus.OK;
        if(searchingProductName == null){
            responseStatus = ResponseStatus.NOT_FOUND;
        }
        return new ResponseDto<ProductDto>(responseStatus, searchingProductName).toResponse();
    }

    @PostMapping("")
    public Response<ProductDto> register(@RequestBody ProductDto productDto){
        ProductDto savingProduct = productService.save(productDto);
        ResponseStatus responseStatus = ResponseStatus.CREATE_DONE;
        if(savingProduct == null){
            responseStatus = ResponseStatus.CREATE_FAIL;
        }
        return new ResponseDto<ProductDto>(responseStatus,savingProduct).toResponse();
    }

    @DeleteMapping("/id")
    public Response<ProductDto> deleteById(@RequestParam("query") String productId){
        ProductDto deletingProduct = productService.deleteProduct(productId);
        ResponseStatus responseStatus = ResponseStatus.CREATE_DONE;
        if(deletingProduct == null){
            responseStatus = ResponseStatus.CREATE_FAIL;
        }
        return new ResponseDto<ProductDto>(responseStatus,deletingProduct).toResponse();
    }
}
