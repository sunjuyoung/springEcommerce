package com.example.ecommerce.dto;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class ProductSearchCondition {


    private Set<String> categoryId;
    private Integer StandardPrice;
    private Integer priceGoe;
    private Integer priceLoe;
}
