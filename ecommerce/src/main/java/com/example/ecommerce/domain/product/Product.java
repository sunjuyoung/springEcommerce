package com.example.ecommerce.domain.product;


import com.example.ecommerce.domain.category.Category;
import com.example.ecommerce.domain.review.Review;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Getter
@Entity
@AllArgsConstructor
public class Product {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "product_id")
    private Long id;

    private String name;

    private int price;

    private String detail;

    private LocalDate regDate;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    @ElementCollection
    @CollectionTable(name = "product_images", joinColumns = @JoinColumn(name = "product_id"))
    private List<Image> images = new ArrayList<>();

    @OneToMany(mappedBy = "product" ,
            cascade = CascadeType.REMOVE,
            orphanRemoval = true)
    private List<Review> review = new ArrayList<>();

    protected Product(){
    }

    public Product(Long id){
        this.id = id;
    }
    public Product( String name, int price, String detail, List<Image> images) {

        this.name = name;
        this.price = price;
        this.detail = detail;
        this.images.addAll(images);
    }


}
