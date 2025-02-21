package com.travel.backend.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "vacations")
public class Vacation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vacation_id")
    private long id;

    @Column(name = "vacation_title")
    private String vacation_title;

    @Column(name = "description")
    private String description;

    @Column(name = "travel_fare_price")
    private BigDecimal travel_price;

    @Column(name = "image_url")
    private String image_URL;

    @Column(name = "create_date")
    private Date create_date;

    @Column(name = "last_update")
    private Date last_update;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vacations")
    private Set<Excursion> excursions;


}
