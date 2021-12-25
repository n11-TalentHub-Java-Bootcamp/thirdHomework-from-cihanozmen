package com.cihanozmen.springboot.mongodb.service;

import com.cihanozmen.springboot.mongodb.entity.ProductComment;

import java.util.List;

public interface ProductCommentService {

    List<ProductComment> findAll();

    ProductComment findById(String id);

    ProductComment save(ProductComment productComment);

    void deleteById(String id);
}
