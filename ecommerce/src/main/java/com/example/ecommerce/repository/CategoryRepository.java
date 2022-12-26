package com.example.ecommerce.repository;

import com.example.ecommerce.domain.category.Category;
import com.example.ecommerce.domain.category.CategoryId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, CategoryId> {
}
