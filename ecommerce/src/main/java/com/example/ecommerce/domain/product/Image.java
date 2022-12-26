package com.example.ecommerce.domain.product;

import javax.persistence.*;

@Entity
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "image_id")
    private Long id;


    @Column(name = "image_path")
    private String path;

    protected Image() {
    }

}
