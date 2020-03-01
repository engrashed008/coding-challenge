package com.codingChallenge.sampleApplication.mapper;

import com.codingChallenge.sampleApplication.dto.ProductDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductMapper {

    List<ProductDto> getProductList();

    ProductDto getSingleProduct(long id);
}
