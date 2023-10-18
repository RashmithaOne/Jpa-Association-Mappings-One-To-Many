package com.rashmithaone.cart.items.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class CartItemsResponseBO {
  
    // name from Cart entity
    private String name; 
    
    // fields from Item entity
    private String cartDescription;
    private String itemName; // 
    private String itemDetails;
    private String brand;
    private int quantity;
}
