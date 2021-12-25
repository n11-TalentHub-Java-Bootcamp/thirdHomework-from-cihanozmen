package com.cihanozmen.springboot.mongodb.controller;

import com.cihanozmen.springboot.mongodb.entity.ProductComment;
import com.cihanozmen.springboot.mongodb.service.ProductCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments/")
public class ProductCommentController {

    @Autowired
    ProductCommentService productCommentService;

    @GetMapping("")
    public List<ProductComment> findAll(){
        return productCommentService.findAll();
    }

    @GetMapping("/{id]")
    public ProductComment findById(@PathVariable String id){

        return productCommentService.findById(id);
    }

    @PostMapping("")
    public ResponseEntity<Object> save(@RequestParam ProductComment productComment){

        productComment = productCommentService.save(productComment);

        return new ResponseEntity<>(productComment, HttpStatus.CREATED);

    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id){
        productCommentService.deleteById(id);
    }

}
