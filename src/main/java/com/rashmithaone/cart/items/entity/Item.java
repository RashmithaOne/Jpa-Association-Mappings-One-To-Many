package com.rashmithaone.cart.items.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String itemDetails;
    private String brand;
    private String brandLocation;
    private int quantity;
    @ManyToOne(fetch= FetchType.LAZY)
    @JsonIgnore
    private Cart cart;
}
