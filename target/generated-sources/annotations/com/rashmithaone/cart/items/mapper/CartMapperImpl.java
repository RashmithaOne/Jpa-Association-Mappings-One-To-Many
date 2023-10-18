package com.rashmithaone.cart.items.mapper;

import com.rashmithaone.cart.items.dto.CartDTO;
import com.rashmithaone.cart.items.dto.CartItemsResponseBO;
import com.rashmithaone.cart.items.entity.Cart;
import com.rashmithaone.cart.items.entity.Item;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-10-17T20:22:04-0500",
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
        List<Item> list = cartDTO.getItems();
        if ( list != null ) {
            cart.setItems( new ArrayList<Item>( list ) );
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
        List<Item> list = cart.getItems();
        if ( list != null ) {
            cartDTO.setItems( new ArrayList<Item>( list ) );
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

    @Override
    public List<CartItemsResponseBO> cartItemsToDto(List<CartItemsResponseBO> carts) {
        if ( carts == null ) {
            return null;
        }

        List<CartItemsResponseBO> list = new ArrayList<CartItemsResponseBO>( carts.size() );
        for ( CartItemsResponseBO cartItemsResponseBO : carts ) {
            list.add( cartItemsResponseBO );
        }

        return list;
    }
}
