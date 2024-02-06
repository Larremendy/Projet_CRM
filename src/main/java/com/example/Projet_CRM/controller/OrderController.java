package com.example.Projet_CRM.controller;

import com.example.Projet_CRM.model.Order;
import com.example.Projet_CRM.service.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("api")
public class OrderController {
    @Autowired
    OrderService orderService;

    // GET orders
    @GetMapping("orders")
    public List<Order> getAll() {
        return orderService.getAll();
    }

    // GET order/1
    @GetMapping("orders/{id}")
    public ResponseEntity<?> getOneById(@PathVariable("id") Integer id) {
        Optional<Order> optional = orderService.getOne(id);

        if (optional.isEmpty())
            return ResponseEntity.badRequest().body("Id non existant");

        return ResponseEntity.ok(optional.get());
    }

    // POST order/1

    @PostMapping("orders")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity add(@RequestBody Order order) {
        if (order == null)
            return ResponseEntity.badRequest().body("Commande à saisir!");

        if (order.getClient() == null)
            // Ajouter des tests - order.getDesignation().isBlank() || order.getNbDays()==null...
            return ResponseEntity.badRequest().body("Client à saisir!");

        orderService.add(order);
        return ResponseEntity.ok(order);
    }



    // DELETE order/1
    @DeleteMapping("orders/{id}")
    public void deleteById(@PathVariable("id") Integer id){
        orderService.deleteById(id);
    }


    // PUT order/1
    @PutMapping("orders/{id}")
    public ResponseEntity<String> put(@PathVariable("id") Integer id, @RequestBody Order newOrder){
        Optional<Order> optional = orderService.getOne(id);

        if(optional.isEmpty())
            return ResponseEntity.notFound().build();

        Order orderToUpdate = optional.get();
        orderService.update(orderToUpdate, newOrder);
        return ResponseEntity.ok("Update réalisée");


    }
}














