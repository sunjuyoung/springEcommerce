package com.example.ecommerce.dto;

import com.example.ecommerce.domain.category.CategoryId;
import com.example.ecommerce.domain.product.Image;
import com.example.ecommerce.domain.product.ProductId;
import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Data
public class CategoryProduct {

    private String  ProductId;
    private String categoryId;
    private String name;
    private int price;
    private String detail;
    private LocalDate regDate;
    private String image;


    @QueryProjection
    public CategoryProduct(String productId, String categoryId, String name,
                           int price, String detail, LocalDate regDate, String image) {
        this.ProductId = productId;
        this.categoryId = categoryId;
        this.name = name;
        this.price = price;
        this.detail = detail;
        this.regDate = regDate;
        this.image = image;
    }
}
