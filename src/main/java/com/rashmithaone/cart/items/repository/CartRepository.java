package com.rashmithaone.cart.items.repository;

import com.rashmithaone.cart.items.dto.CartItemsResponseBO;
import com.rashmithaone.cart.items.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {
  
    // JPQL query to pull the cart items and join the cart and item tables with the return type - CartItemsResponseBO
    @Query(value = "SELECT new com.rashmithaone.cart.items.dto.CartItemsResponseBO(c.name, c.description, i.name, i.itemDetails, i.brand, i.quantity) FROM Cart c JOIN c.items i")
    public List<CartItemsResponseBO> getAllCartItemsCustomDetails();
}
