package com.example.ecommerce.repository;

import com.example.ecommerce.dto.CategoryProduct;
import com.example.ecommerce.dto.ProductSearchCondition;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
public interface ProductSearchRepository {

    List<CategoryProduct> searchProductBuilder(ProductSearchCondition condition);
}
