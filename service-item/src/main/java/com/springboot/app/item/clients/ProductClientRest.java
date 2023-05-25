package com.springboot.app.item.clients;

import com.springboot.app.item.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "service-products")
public interface ProductClientRest {

    @GetMapping("/product")
    public List<Product> list();

    @GetMapping("/product/{id}")
    public Product getById(@PathVariable Long id);
}
