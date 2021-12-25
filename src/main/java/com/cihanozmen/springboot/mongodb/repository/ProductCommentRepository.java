package com.cihanozmen.springboot.mongodb.repository;

import com.cihanozmen.springboot.mongodb.entity.ProductComment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductCommentRepository extends MongoRepository<ProductComment, String> {

}
