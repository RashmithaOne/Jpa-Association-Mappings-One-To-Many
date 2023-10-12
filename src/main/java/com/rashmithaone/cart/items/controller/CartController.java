package com.rashmithaone.cart.items.controller;

import com.rashmithaone.cart.items.dto.CartDTO;
import com.rashmithaone.cart.items.entity.Cart;
import com.rashmithaone.cart.items.mapper.CartMapper;
import com.rashmithaone.cart.items.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/carts")
public class CartController {

    @Autowired
    private CartMapper cartMapper;

    @Autowired
    private CartRepository cartRepository;

    @PostMapping("/insert-items")
    public ResponseEntity<Cart> insertCart(@RequestBody CartDTO cartDTO){

        return new ResponseEntity<>(cartRepository.save(cartMapper.dtoToEntity(cartDTO)), HttpStatus.CREATED);
    }

    @GetMapping("/all-cart-items")
    public ResponseEntity<List<CartDTO>> allCartItems(){
        return new ResponseEntity<>(cartMapper.allCartItemsToDto(cartRepository.findAll()), HttpStatus.OK);
    }


}
