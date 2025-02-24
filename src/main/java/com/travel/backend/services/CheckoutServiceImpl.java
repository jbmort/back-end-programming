package com.travel.backend.services;

import com.travel.backend.dao.CustomerRepository;
import com.travel.backend.entities.Cart;
import com.travel.backend.entities.CartItem;
import com.travel.backend.entities.Customer;
import com.travel.backend.entities.StatusType;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

@Service
public class CheckoutServiceImpl implements CheckoutService{

    private final CustomerRepository customerRepository;

    public CheckoutServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase) {

        String response = "";
        if (purchase.getCart() == null || purchase.getCartItems() == null || purchase.getCartItems().size() < 1) {
            response = "Cart cannot be empty";
        } else {
            Cart cart = purchase.getCart();
            response = generateOrderTrackingNumber();

            cart.setOrderTrackingNumber(response);

            Set<CartItem> cartItems = purchase.getCartItems();
            cartItems.forEach(item -> cart.add(item));

            cart.setStatus(StatusType.ordered);

            Customer customer = purchase.getCustomer();
            customer.add(cart);

            customerRepository.save(customer);
        }

        return new PurchaseResponse(response);
    }


    private String generateOrderTrackingNumber() {
        return UUID.randomUUID().toString();
    }
}
