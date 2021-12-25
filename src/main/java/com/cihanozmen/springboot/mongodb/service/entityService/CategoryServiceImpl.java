package com.cihanozmen.springboot.mongodb.service.entityService;

import com.cihanozmen.springboot.mongodb.entity.Category;
import com.cihanozmen.springboot.mongodb.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryEntityService categoryEntityService;

    @Override
    public List<Category> findAll() {
        return categoryEntityService.findAll();
    }

    @Override
    public Category findById(String id) {
        return categoryEntityService.findById(id);
    }

    @Override
    public Category save(Category category) {
        return categoryEntityService.save(category);
    }

    @Override
    public void deleteById(String id) {
        categoryEntityService.deleteById(id);
    }
}
