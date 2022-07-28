package com.example.demo.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "city_id", nullable = false)
    private Long cityId;

    @NotNull
    private String cityName;



    @CreationTimestamp
    @Column(name = "create_date", nullable = false)
    private Date createDate;

    @UpdateTimestamp
    @Column(name ="update_date",nullable = true)
    private Date updateDate;



}
