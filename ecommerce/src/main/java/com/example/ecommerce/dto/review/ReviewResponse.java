package com.example.ecommerce.dto.review;

import com.example.ecommerce.domain.member.Member;
import com.example.ecommerce.domain.product.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReviewResponse implements Serializable {

    private Long id;

    private String title;
    private String content;

    private Long member_id;
    private String memberName;

    private Long product_id;

    private LocalDateTime modifyDate;



}
