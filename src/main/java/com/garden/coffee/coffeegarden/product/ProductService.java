package com.garden.coffee.coffeegarden.product;


import com.garden.coffee.coffeegarden.DtoList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductService {
    @Autowired
    ProductJPARepository productRepository;

    public DtoList<ProductDto> getAllProduct() {
        DtoList<ProductDto> gettingProductList = new DtoList<>(productRepository.findAll());
        return gettingProductList;
    }
    public ProductDto getProduct(String productId){
        Optional<Product> optProduct = productRepository.findById(productId);
        if(optProduct.isEmpty()){
            return null;
        }
        ProductDto gettingProduct = new ProductDto(optProduct.get());
        return gettingProduct;

    }
    public ProductDto save(ProductDto productDto){
        productDto.setProductId(UUID.randomUUID().toString().replace("-",""));
        productRepository.save(productDto.toEntity());
        return productDto;
    }



    public ProductDto deleteProduct(String productId){
        Optional<Product> optProduct = productRepository.findById(productId);
        if(optProduct.isEmpty()){
            return null;
        }
        ProductDto deletingProduct = new ProductDto(optProduct.get());
        productRepository.deleteById(productId);
        return deletingProduct;
    }


}
