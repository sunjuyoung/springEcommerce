package com.example.ecommerce.dto;

import com.example.ecommerce.domain.category.CategoryId;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class ProductSearchCondition {

    private Set<CategoryId> categoryId = new HashSet<>();
    private Integer StandardPrice;
    private Integer priceGoe;
    private Integer priceLoe;
}
