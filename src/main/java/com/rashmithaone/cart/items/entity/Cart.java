package com.rashmithaone.cart.items.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cartId;
    private String name;
    private String description;

    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    // CascadeType.ALL can do all the operations. CascadeType.PERSIST can only perform writing the data to the db, and
    // it can ignore the rest of the operations such as PUT, DELETE.
    // It is not recommended to use the CascadeType to use ALL since that may also perform the
    // UPDATE, DELETE the records in the Child table when a operation is being called.
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "cart_items_fk"
            //, referencedColumnName = "cartId"
             )
    private List<Item> items;
}
