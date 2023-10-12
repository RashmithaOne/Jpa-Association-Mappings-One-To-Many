package com.rashmithaone.cart.items.dto;

import com.rashmithaone.cart.items.entity.Item;
import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class CartDTO {

    private int cartId;
    private String name;
    private String description;
    private Set<Item> items = new TreeSet<>();
}
