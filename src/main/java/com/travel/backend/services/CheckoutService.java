package com.travel.backend.services;

public interface CheckoutService {
    PurchaseResponse placeOrder(Purchase purchase);
}
