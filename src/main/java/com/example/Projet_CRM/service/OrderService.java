package com.example.Projet_CRM.service;

import com.example.Projet_CRM.dao.OrderRepository;
import com.example.Projet_CRM.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;

    public void getAll(){
        orderRepository.findAll();
    }

    public Optional<Order> getOne(Integer id){
        orderRepository.findById(id);
    }

    public void add(Order order){
        orderRepository.save(order);
    }
}
