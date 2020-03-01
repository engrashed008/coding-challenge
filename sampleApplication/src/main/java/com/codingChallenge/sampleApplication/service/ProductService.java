package com.codingChallenge.sampleApplication.service;

import com.codingChallenge.sampleApplication.dto.ProductDto;
import com.codingChallenge.sampleApplication.enums.ErrorStatus;
import com.codingChallenge.sampleApplication.exception.ServiceException;
import com.codingChallenge.sampleApplication.mapper.ProductMapper;
import com.github.pagehelper.PageHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductMapper productMapper;

    public List<ProductDto> getList(int page, int limit) {
        PageHelper.startPage(page, limit);
        //List<ProductDto> list = productMapper.getProductList();
        List<ProductDto> list = getSmapleProductList();
        if (list.size() == 0) {
            throw new ServiceException(ErrorStatus.DATA_NOT_FOUND);
        }
        return list;
    }

    public ProductDto getSingle(long id) {
        // ProductDto singleProd = productMapper.getSingleProduct(id);
        // Sample output
        ProductDto singleProd = getSingleSampleProduct(id);
        return singleProd;
    }

    private ProductDto getSingleSampleProduct(long id) {
        ProductDto p2 = new ProductDto();
        p2.setId(id);
        p2.setName("fuchsia rose");
        p2.setYear(2001);
        p2.setColor("#C74375");
        p2.setPantone_value("17-2031");
        return p2;
    }

    private List<ProductDto> getSmapleProductList() {
        List<ProductDto> list = new ArrayList<>();
        ProductDto p1 = new ProductDto();
        p1.setId(1L);
        p1.setName("cerulean");
        p1.setYear(2000);
        p1.setColor("#98B2D1");
        p1.setPantone_value("15-4020");
        list.add(p1);

        ProductDto p2 = new ProductDto();
        p2.setId(2L);
        p2.setName("fuchsia rose");
        p2.setYear(2001);
        p2.setColor("#C74375");
        p2.setPantone_value("17-2031");
        list.add(p2);

        ProductDto p3 = new ProductDto();
        p3.setId(3L);
        p3.setName("true red");
        p3.setYear(2002);
        p3.setColor("#BF1932");
        p3.setPantone_value("19-1664");
        list.add(p3);

        ProductDto p4 = new ProductDto();
        p4.setId(4L);
        p4.setName("aqua sky");
        p4.setYear(2003);
        p4.setColor("#7BC4C4");
        p4.setPantone_value("14-4811");
        list.add(p4);

        ProductDto p5 = new ProductDto();
        p5.setId(5L);
        p5.setName("tigerlily");
        p5.setYear(2004);
        p5.setColor("#E2583E");
        p5.setPantone_value("17-1456");
        list.add(p5);

        ProductDto p6 = new ProductDto();
        p6.setId(6L);
        p6.setName("blue turquoise");
        p6.setYear(2005);
        p6.setColor("#53B0AE");
        p6.setPantone_value("15-5217");
        list.add(p6);

        ProductDto p7 = new ProductDto();
        p7.setId(7L);
        p7.setName("true red");
        p7.setYear(2006);
        p7.setColor("#BF1932");
        p7.setPantone_value("19-1664");
        list.add(p7);

        return list;
    }
}
