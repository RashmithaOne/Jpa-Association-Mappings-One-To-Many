package com.rashmithaone.cart.items.controller;

import com.rashmithaone.cart.items.dto.CartDTO;
import com.rashmithaone.cart.items.dto.CartItemsResponseBO;
import com.rashmithaone.cart.items.entity.Cart;
import com.rashmithaone.cart.items.mapper.CartMapper;
import com.rashmithaone.cart.items.repository.CartRepository;
import com.rashmithaone.cart.items.repository.ItemRepository;
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

    @Autowired
    private ItemRepository itemRepository;

    @PostMapping("/insert-items")
    public ResponseEntity<Cart> insertCart(@RequestBody CartDTO cartDTO){

        return new ResponseEntity<>(cartRepository.save(cartMapper.dtoToEntity(cartDTO)), HttpStatus.CREATED);
    }

    @GetMapping("/all-cart-items")
    public ResponseEntity<List<CartDTO>> allCartItems(){
        return new ResponseEntity<>(cartMapper.allCartItemsToDto(cartRepository.findAll()), HttpStatus.OK);
    }

    @GetMapping("/cart-items/{id}")
    public ResponseEntity<CartDTO> fetchCartItemByCartId(@PathVariable int id){
        return new ResponseEntity<>(cartMapper.entityToDto(cartRepository.findById(id).orElse(null)), HttpStatus.OK);
    }

    @GetMapping("/all-cart-items-custom-details")
    public ResponseEntity<List<CartItemsResponseBO>> getCartItemsCustomDetails(){
        return new ResponseEntity<>(cartMapper.cartItemsToDto( cartRepository.getAllCartItemsCustomDetails()), HttpStatus.OK);
    }

    @PutMapping("/update-cart-item")
    public ResponseEntity<Cart> updateItem(@RequestBody CartDTO cartDTO){

        Cart savedCart = cartRepository.save(cartMapper.dtoToEntity(cartDTO));
        return new ResponseEntity<>
                (savedCart, HttpStatus.OK);
    }

    @DeleteMapping("/delete-item/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteItemByPK(@PathVariable int id){
        CartDTO cartId = cartMapper.entityToDto(cartRepository.findById(id).orElse(null));
        cartRepository.deleteById(cartId.getCartId());
    }

}
