package com.springboot.app.products.service;

import com.springboot.app.products.model.Product;
import com.springboot.app.products.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {
    private final ProductRepository repository;

    @Transactional(readOnly = true)
    public List<Product> findAll(){
        return repository.findAll();
    }
    @Transactional(readOnly = true)
    public Product findById(Long id){
        return repository.findById(id).orElseThrow(()-> new RuntimeException());
    }
}
