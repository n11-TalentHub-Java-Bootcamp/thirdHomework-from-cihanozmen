package com.cihanozmen.springboot.mongodb.service.entityService;

import com.cihanozmen.springboot.mongodb.entity.ProductComment;
import com.cihanozmen.springboot.mongodb.service.ProductCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductCommentServiceImpl implements ProductCommentService {
    @Autowired
    private ProductCommentEntityService productCommentEntityService;


    @Override
    public List<ProductComment> findAll() {
        return productCommentEntityService.findAll();
    }

    @Override
    public ProductComment findById(String id) {
        return productCommentEntityService.findById(id);
    }

    @Override
    public ProductComment save(ProductComment productComment) {
        return productCommentEntityService.save(productComment);
    }

    @Override
    public void deleteById(String id) {
        productCommentEntityService.deleteById(id);
    }
}
