package com.cihanozmen.springboot.mongodb.service;

import com.cihanozmen.springboot.mongodb.entity.Category;

import java.util.List;

public interface CategoryService {

    List<Category> findAll();

    Category findById(String id);

    Category save(Category category);

    void deleteById(String id);
}
