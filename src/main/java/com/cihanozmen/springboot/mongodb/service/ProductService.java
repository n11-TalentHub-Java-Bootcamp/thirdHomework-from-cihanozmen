package com.cihanozmen.springboot.mongodb.service;


import com.cihanozmen.springboot.mongodb.dto.ProductDetailDto;
import com.cihanozmen.springboot.mongodb.entity.Product;

import java.util.List;

public interface ProductService {

    List<Product> findAll();

    Product findById(String id);

    ProductDetailDto findProductDetailDtoById(String id);

    Product save(Product product);

    void deleteById(String id);

    List<ProductDetailDto> findAllProductByCategoryId(String id);

}
