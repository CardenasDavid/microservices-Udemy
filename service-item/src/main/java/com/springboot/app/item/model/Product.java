package com.springboot.app.item.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Product {
    private Long id;
    private String name;
    private Double price;
    private Date createAt;
    private Integer port;
}
