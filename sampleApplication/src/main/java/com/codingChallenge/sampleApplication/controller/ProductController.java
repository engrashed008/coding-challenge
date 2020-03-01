package com.codingChallenge.sampleApplication.controller;

import com.codingChallenge.sampleApplication.common.CommonPage;
import com.codingChallenge.sampleApplication.common.CommonResponse;
import com.codingChallenge.sampleApplication.dto.ProductDto;
import com.codingChallenge.sampleApplication.enums.ErrorStatus;
import com.codingChallenge.sampleApplication.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/products")
    public CommonResponse<CommonPage<ProductDto>> fetchProductList(@RequestParam(defaultValue = "1") int page,
                                                                   @RequestParam(defaultValue = "6") int limit) {
        List<ProductDto> list = productService.getList(page, limit);
        return CommonResponse.success(CommonPage.restPage(list));
    }

    @GetMapping("/products/{id}")
    public CommonResponse<ProductDto> fetchSingleProduct(@PathVariable @NotNull Long id) {
        ProductDto list = productService.getSingle(id);
        if (list == null) {
            return CommonResponse.failed(HttpStatus.NOT_FOUND, ErrorStatus.DATA_NOT_FOUND.getErrorMessage());
        }
        return CommonResponse.success(list);
    }


}
