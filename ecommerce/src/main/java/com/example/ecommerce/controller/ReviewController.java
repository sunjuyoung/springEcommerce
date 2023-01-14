package com.example.ecommerce.controller;


import com.example.ecommerce.dto.MemberResponse;
import com.example.ecommerce.dto.MemberUpdateRequest;
import com.example.ecommerce.dto.review.ReviewRequest;
import com.example.ecommerce.dto.review.ReviewResponse;
import com.example.ecommerce.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/review")
public class ReviewController {

    private final ReviewService reviewService;

    @PostMapping
    public ResponseEntity<?> saveReview(@RequestBody ReviewRequest reviewRequest){
        reviewService.saveReview(reviewRequest);
        return ResponseEntity.ok().body("success");
    }

    @GetMapping
    public ResponseEntity<List<ReviewResponse>> getReviews(){
        List<ReviewResponse> reviews = reviewService.getReviews();
        return ResponseEntity.ok().body(reviews);
    }
    @GetMapping("/{reviewId}")
    public ResponseEntity<ReviewResponse> getReview(@PathVariable("reviewId")Long mId){
        ReviewResponse review = reviewService.getReview(mId);
        return ResponseEntity.ok().body(review);
    }

    @PutMapping("/{reviewId}")
    public ResponseEntity<?> editReview(@PathVariable("reviewId")Long mId,
                                          @RequestBody ReviewRequest request){
        reviewService.editReview(mId,request);
        return ResponseEntity.ok().body("success");
    }
    @DeleteMapping("/{reviewId}")
    public ResponseEntity<?> deleteReview(@PathVariable("reviewId")Long mId){
        reviewService.deleteReivew(mId);
        return ResponseEntity.ok().body("success");
    }
}
