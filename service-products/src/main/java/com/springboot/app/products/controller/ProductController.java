package com.springboot.app.products.controller;

import com.springboot.app.products.model.Product;
import com.springboot.app.products.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService service;

    @Autowired
    private Environment environment;

    @Value("${server.port}")
    private Integer port;

    @GetMapping
    public List<Product> list(){
        return service.findAll().stream().map(product->{
            product.setPort(Integer.valueOf(environment.getProperty("local.server.port")));
            //product.setPort(port);
            return product;
        }).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public Product getById(@PathVariable Long id){
        Product product= service.findById(id);
        product.setPort(Integer.valueOf(environment.getProperty("local.server.port")));
        //product.setPort(port);
        return product;
    }
}
