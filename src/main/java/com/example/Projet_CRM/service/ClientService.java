package com.example.Projet_CRM.service;

import com.example.Projet_CRM.dao.ClientRepository;
import com.example.Projet_CRM.model.Client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    ClientRepository clientRepository;

    public List<Client> getAll(){
        return clientRepository.findAll();
    }

    public Optional<Client> getOneById(Integer id){
        return clientRepository.findById(id);
    }

    public void addClient(Client client){
        clientRepository.save(client);
    }

    public void deleteById(Integer id){
        clientRepository.deleteById(id);
    }

    public void update(Client newClient){
        clientRepository.save(newClient);
    }

}
