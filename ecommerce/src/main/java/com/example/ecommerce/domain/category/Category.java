package com.example.ecommerce.domain.category;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
@AllArgsConstructor
public class Category {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "category_id")
    private Long id;

    @Column(name = "name")
    private String name;

    protected Category() {
    }
    public Category(String name) {
        this.name = name;
    }
}
