package com.cihanozmen.springboot.mongodb.service.entityService;

import com.cihanozmen.springboot.mongodb.conventer.ProductConverter;
import com.cihanozmen.springboot.mongodb.dto.ProductDetailDto;
import com.cihanozmen.springboot.mongodb.entity.Product;
import com.cihanozmen.springboot.mongodb.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductEntitySerivce productEntitySerivce;

    @Override
    public List<Product> findAll() {
        return productEntitySerivce.findAll();
    }

    @Override
    public Product findById(String id) {
        return productEntitySerivce.findById(id);
    }

    @Override
    public ProductDetailDto findProductDetailDtoById(String id) {

        Product product = productEntitySerivce.findById(id);

        ProductDetailDto productDetailDto = ProductConverter.INSTANCE.convertProductToProductDetailDto(product);

        return productDetailDto;
    }

    @Override
    public Product save(Product product) {
        return productEntitySerivce.save(product);
    }

    @Override
    public void deleteById(String id) {
        productEntitySerivce.delete(id);
    }

    @Override
    public List<ProductDetailDto> findAllProductByCategoryId(String categoryId) {

        List<Product> productList = productEntitySerivce.findAllProductByCategoryId(categoryId);

        List<ProductDetailDto> productDetailDtoList = ProductConverter.INSTANCE.convertAllProductListToProductDetailDtoList(productList);

        return productDetailDtoList;
    }
}
