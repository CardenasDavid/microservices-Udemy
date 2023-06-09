package com.springboot.app.item.service;

import com.springboot.app.item.model.Item;
import com.springboot.app.item.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service("serviceRestTemplate")
public class ItemServiceImpl implements ItemService{
    @Autowired
    private RestTemplate clientRest;

    @Override
    public List<Item> findAll() {
        List<Product> products= Arrays.asList(clientRest.getForObject("http://localhost:8001/product",Product[].class));
        return products.stream().map(p-> new Item(p,1)).collect(Collectors.toList());
    }

    @Override
    public Item findById(Long id, Integer quantity) {
        Map<String,String> pathVariables= new HashMap<String, String>();
        pathVariables.put("id",id.toString());

        Product product= clientRest.getForObject("http://localhost:8001/product/{id}", Product.class,pathVariables);
        return new Item(product,quantity);
    }
}
