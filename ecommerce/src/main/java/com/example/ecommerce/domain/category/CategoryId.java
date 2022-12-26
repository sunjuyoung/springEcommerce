package com.example.ecommerce.domain.category;

import lombok.EqualsAndHashCode;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@EqualsAndHashCode(of = "id")
@Access(AccessType.FIELD)
public class CategoryId implements Serializable {

    @Column(name = "category_id")
    private String id;

    protected CategoryId() {
    }

    public String getId() {
        return id;
    }
    public CategoryId(String id) {
        this.id = id;
    }
    public static CategoryId of(String id) {
        return new CategoryId(id);
    }
}
