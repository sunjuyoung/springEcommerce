package com.example.ecommerce.repository;

import com.example.ecommerce.dto.ProductSearchCondition;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductSearchRepositoryImplTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void test() throws Exception{
        //given

        ProductSearchCondition condition = new ProductSearchCondition();
        condition.setPriceGoe(1000);
        condition.setPriceLoe(20);
        condition.setStandardPrice(1000);

        productRepository.searchProductBuilder(condition);

        //when

        //then
    }
}