package com.fiserv.fs.helix.model;

import io.quarkus.hibernate.reactive.panache.PanacheEntity;
import io.quarkus.hibernate.reactive.panache.PanacheEntityBase;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Cacheable
public class Party extends PanacheEntityBase {
    @Id
    //@Column(length = 4, unique = true, nullable = false, updatable = false)
    public long id;

    //@Column(length = 70)
    public String name;

    //@Column(length = 3)
    public int age;

    public String address;
}
