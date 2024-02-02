package com.example.Projet_CRM.dao;

import com.example.Projet_CRM.metier.Client;
import com.example.Projet_CRM.metier.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
