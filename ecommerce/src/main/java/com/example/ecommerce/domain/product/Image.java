package com.example.ecommerce.domain.product;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.*;


@Getter
@Embeddable
@AllArgsConstructor
public class Image {


    @Column(name = "image_id")
    private Long id;


    @Column(name = "image_path")
    private String path;

    protected Image() {
    }

}
