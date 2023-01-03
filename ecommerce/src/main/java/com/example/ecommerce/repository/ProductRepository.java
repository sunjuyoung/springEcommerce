package com.example.ecommerce.repository;

import com.example.ecommerce.domain.product.Product;
import com.example.ecommerce.domain.product.ProductId;
import com.example.ecommerce.dto.ProductSearchCondition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, ProductId>, ProductSearchRepository {

}
