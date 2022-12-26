package com.example.ecommerce.domain.order;

import com.example.ecommerce.domain.member.Address;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Embeddable
@NoArgsConstructor
public class ShippingInfo {

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "zipCode", column = @Column(name = "shipping_zip_code")),
            @AttributeOverride(name = "address1", column = @Column(name = "shipping_addr1")),
            @AttributeOverride(name = "address2", column = @Column(name = "shipping_addr2"))
    })
    private Address address;

    @Column(name = "receiver_name")
    private String name;

    @Column(name = "shipping_message")
    private String message;

    public ShippingInfo(Address address, String name, String message) {
        this.address = address;
        this.name = name;
        this.message = message;
    }


}
