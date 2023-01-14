package com.example.ecommerce.repository;

import com.example.ecommerce.domain.review.Review;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ReviewRepository extends JpaRepository<Review,Long> {

    @EntityGraph(attributePaths = "member")
    Optional<Review> findReviewAndMemberById(Long id);


    @EntityGraph(attributePaths = {"member","product"})
    List<Review> findBy();
}
