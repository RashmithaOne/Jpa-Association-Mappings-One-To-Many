package com.rashmithaone.cart.items.mapper;

import com.rashmithaone.cart.items.dto.CartDTO;
import com.rashmithaone.cart.items.entity.Cart;
import com.rashmithaone.cart.items.entity.Item;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-10-11T22:51:54-0500",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 17.0.8.1 (Eclipse Adoptium)"
)
@Component
public class CartMapperImpl implements CartMapper {

    @Override
    public Cart dtoToEntity(CartDTO cartDTO) {
        if ( cartDTO == null ) {
            return null;
        }

        Cart cart = new Cart();

        cart.setCartId( cartDTO.getCartId() );
        cart.setName( cartDTO.getName() );
        cart.setDescription( cartDTO.getDescription() );
        Set<Item> set = cartDTO.getItems();
        if ( set != null ) {
            cart.setItems( new HashSet<Item>( set ) );
        }

        return cart;
    }

    @Override
    public CartDTO entityToDto(Cart cart) {
        if ( cart == null ) {
            return null;
        }

        CartDTO cartDTO = new CartDTO();

        cartDTO.setCartId( cart.getCartId() );
        cartDTO.setName( cart.getName() );
        cartDTO.setDescription( cart.getDescription() );
        Set<Item> set = cart.getItems();
        if ( set != null ) {
            cartDTO.setItems( new HashSet<Item>( set ) );
        }

        return cartDTO;
    }

    @Override
    public List<CartDTO> allCartItemsToDto(List<Cart> carts) {
        if ( carts == null ) {
            return null;
        }

        List<CartDTO> list = new ArrayList<CartDTO>( carts.size() );
        for ( Cart cart : carts ) {
            list.add( entityToDto( cart ) );
        }

        return list;
    }
}
