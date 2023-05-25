package com.springboot.app.item.controller;

import com.springboot.app.item.model.Item;
import com.springboot.app.item.service.ItemService;
import com.springboot.app.item.service.ItemServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/item")
public class ItemController {

    @Autowired
    @Qualifier("serviceFeing")
    private ItemService itemService;

    @GetMapping
    public List<Item> list(){
        return  itemService.findAll();
    }

    @GetMapping("/{id}/quantity/{quantity}")
    public Item getItemById(@PathVariable Long id, @PathVariable Integer quantity){
        return  itemService.findById(id, quantity);
    }

}
