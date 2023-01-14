package com.example.ecommerce.service;

import com.example.ecommerce.domain.member.Member;
import com.example.ecommerce.domain.product.Product;
import com.example.ecommerce.domain.review.Review;
import com.example.ecommerce.dto.MemberResponse;
import com.example.ecommerce.dto.review.ReviewRequest;
import com.example.ecommerce.dto.review.ReviewResponse;
import com.example.ecommerce.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final ModelMapper modelMapper;
    public List<ReviewResponse> getReviews() {
        List<Review> reviews = reviewRepository.findBy();
        List<ReviewResponse> reviewResponses = new ArrayList<>();
        reviews.forEach(review -> {
            reviewResponses.add(ReviewResponse.builder()
                            .id(review.getId())
                            .content(review.getContent())
                            .title(review.getTitle())
                            .member_id(review.getMember().getId())
                            .memberName(review.getMember().getName())
                            .modifyDate(review.getModifyDate())
                    .build());
        });
        return reviewResponses;

    }

    public ReviewResponse getReview(Long mId) {
        Review review = reviewRepository.findById(mId).orElseThrow();
        return modelMapper.map(review,ReviewResponse.class);
    }

    @Transactional
    public void editReview(Long mId, ReviewRequest request) {
        Review review = reviewRepository.findReviewAndMemberById(mId).orElseThrow();
        SecurityContextHolder.getContext().getAuthentication().getAuthorities();
        review.editReview(request);
    }

    public void deleteReivew(Long mId) {
    }

    public void saveReview(ReviewRequest reviewRequest) {
        Review review = new Review(reviewRequest,
                new Member(reviewRequest.getMember_id()),
                new Product(reviewRequest.getProduct_id()));
        reviewRepository.save(review);

    }
}
