package com.travel.backend.services;

import com.travel.backend.dao.CustomerRepository;
import com.travel.backend.entities.Cart;
import com.travel.backend.entities.CartItem;
import com.travel.backend.entities.Customer;
import com.travel.backend.entities.StatusType;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;
import java.util.UUID;

public class CheckoutServiceImpl implements CheckoutService{

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase) {

        if(purchase.getCart() == null || purchase.getCartItems() == null || purchase.getCartItems().size() < 1){
            return new PurchaseResponse("Cart cannot be empty");
        }
        else{
            Cart cart = purchase.getCart();

            String orderTrackingNumber = generateOrderTrackingNumber();
            cart.setOrderTrackingNumber(orderTrackingNumber);

            Set<CartItem> cartItems = purchase.getCartItems();
            cartItems.forEach(item -> cart.add(item));

            cart.setStatus(StatusType.ordered);

            Customer customer = purchase.getCustomer();
            customer.add(cart);

            customerRepository.save(customer);

            return new PurchaseResponse(orderTrackingNumber);
        }
    }

    private String generateOrderTrackingNumber() {
        return UUID.randomUUID().toString();
    }
}
