package com.rashmithaone.cart.items.dto;

import com.rashmithaone.cart.items.entity.Item;
import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class CartDTO {

    private int cartId;
    private String name;
    private String description;
    private List<Item> items;
}
