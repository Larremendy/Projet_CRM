package com.example.Projet_CRM.controller;

import com.example.Projet_CRM.dao.ClientRepository;
import com.example.Projet_CRM.model.Client;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api")
public class ClientController {

    ClientRepository clientRepository;

    // GET clients
    GetMapping("clients")
    public List<Client> getAll(){
        return clientRepository.findAll();
    }

    // GET client/i
    public ResponseEntity getOneById(Integer id){}

    // POST clients

    // DELETE client/i

    // PUT client/i


}
