package com.example.ecommerce.dto.review;

import lombok.Data;

@Data
public class ReviewRequest {

    private Long id;

    private String title;

    private String content;

    private Long member_id;

    private Long product_id;
}
