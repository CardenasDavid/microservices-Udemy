package com.springboot.app.products.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "products")
@Getter
@Setter
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double price;
    @Column(name = "create_at")
    @Temporal(TemporalType.DATE)
    private Date createAt;
    @Transient
    private Integer port;

}
