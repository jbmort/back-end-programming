package com.travel.backend.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "carts")
public class Cart {

    @Id
    @Column(name = "cart_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "package_price")
    private BigDecimal package_price;

    @Column(name = "order_tracking_number")
    private String orderTrackingNumber;

    @Column(name = "party_size")
    private int party_size;

    @Column(name = "status")
    private StatusType status;

    @Column(name = "create_date")
    private Date create_date;

    @Column(name = "last_update")
    private Date last_update;

    @ManyToOne()
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "carts")
    private Set<CartItem> cartItem;



}
