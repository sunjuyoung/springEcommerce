package com.example.ecommerce.domain.category;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Getter
@Entity
public class Category {

    @EmbeddedId
    private CategoryId id;

    @Column(name = "name")
    private String name;

    protected Category() {
    }
    public Category(CategoryId id, String name) {
        this.id = id;
        this.name = name;
    }
}
