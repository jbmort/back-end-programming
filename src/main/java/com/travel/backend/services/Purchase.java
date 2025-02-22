package com.travel.backend.services;

import com.travel.backend.entities.Cart;
import com.travel.backend.entities.CartItem;
import com.travel.backend.entities.Customer;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class Purchase {
    private Customer customer;
    private Cart cart;
    private Set<CartItem> cartItems;
}
