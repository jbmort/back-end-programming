package com.travel.backend.entities;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "countries")
public class Country {

    @Id
    @Column(name = "country_id")
    private long id;

    @Column(name = "country")
    private String country_name;

    @Column(name = "create_date")
    private Date create_date;

    @Column(name = "last_update")
    private Date last_update;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "countries")
    private Set<Division> divisions;


}
