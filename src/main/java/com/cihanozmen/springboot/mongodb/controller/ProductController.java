package com.cihanozmen.springboot.mongodb.controller;

import com.cihanozmen.springboot.mongodb.dto.ProductDetailDto;
import com.cihanozmen.springboot.mongodb.entity.Product;
import com.cihanozmen.springboot.mongodb.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products/")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("")
    public MappingJacksonValue findAllUrunList(){
        List<Product> products = productService.findAll();

        MappingJacksonValue mapping= new MappingJacksonValue(products);

        return mapping;
    }
    @GetMapping("/{id}")
    public MappingJacksonValue findById(@PathVariable String id){
        Product product = productService.findById(id);

        WebMvcLinkBuilder linkToUrun = WebMvcLinkBuilder.linkTo(
                WebMvcLinkBuilder.methodOn(this.getClass()).findAllUrunList()
        );

        EntityModel entityModel = EntityModel.of(product);

        entityModel.add(linkToUrun.withRel("tum-urunler"));

        MappingJacksonValue mapping = new MappingJacksonValue(entityModel);
        return mapping;

    }

    @GetMapping("/detail/{id}")
    public ProductDetailDto findProductDetailDtoById(@PathVariable String id){
        return productService.findProductDetailDtoById(id);
    }

    @PostMapping("")
    public ResponseEntity<Object> saveUrun(/**@Valid*/@RequestBody Product product){
        product = productService.save(product);

        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public void deleteUrun(@PathVariable String id){
        productService.deleteById(id);
    }

    @GetMapping("kategoriler/{categoryId}")
    public List<ProductDetailDto> findAllUrunByKategoriId(@PathVariable String categoryId){
        return productService.findAllProductByCategoryId(categoryId);
    }

}
