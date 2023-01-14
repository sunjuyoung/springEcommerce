package com.example.ecommerce.domain.review;


import com.example.ecommerce.domain.member.Member;
import com.example.ecommerce.domain.product.Product;
import com.example.ecommerce.dto.review.ReviewRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Entity
@AllArgsConstructor
public class Review {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "review_id")
    private Long id;

    private String title;

    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    private LocalDateTime regDate;
    private LocalDateTime modifyDate;

    protected Review(){

    }

    public void editReview(ReviewRequest request) {
        this.title = request.getTitle();
        this.content = request.getContent();
    }

    public Review(ReviewRequest request,Member member, Product product){
        this.title = request.getTitle();
        this.member = member;
        this.product = product;
        this.content = request.getContent();
        this.regDate = LocalDateTime.now();
        this.modifyDate = LocalDateTime.now();
    }
}
