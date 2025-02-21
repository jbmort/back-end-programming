package com.travel.backend.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigInteger;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "divisions")
public class Division {
    @Id
    @Column(name = "division_id")
    private long id;

    @Column(name = "division")
    private String division_name;

    @Column(name = "create_date")
    @CreationTimestamp
    private Date create_date;

    @Column(name = "last_update")
    @UpdateTimestamp
    private Date last_update;

    @Column(name = "country_id")
    private long country_id;

    @ManyToOne()
    @JoinColumn(name = "country_id", nullable = false)
    private Country country;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "division")
    private Set<Customer> customers;



}
