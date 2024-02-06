package com.example.Projet_CRM.service;

import com.example.Projet_CRM.dao.ClientRepository;
import com.example.Projet_CRM.dao.OrderRepository;
import com.example.Projet_CRM.model.Client;

import com.example.Projet_CRM.model.ClientState;
import com.example.Projet_CRM.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    ClientRepository clientRepository;

    @Autowired
    OrderRepository orderRepository;

    public List<Client> getAll(){
        return clientRepository.findAll();
    }

    public Optional<Client> getOneById(Integer id){
        return clientRepository.findById(id);
    }

    public void addClient(Client client){
        clientRepository.save(client);
    }

    public void deleteClient(Client client){
        List<Order> orderList = orderRepository.findAll();
        for(Order order : orderList) {
            if (order.getClient().getId() == client.getId()){
                order.setClient(null);
            }
            orderRepository.save(order);
        }
        client.setClientState(ClientState.INACTIVE);

        clientRepository.save(client);
    }

    // Mise à jour du client par remplacement avec les nouvelles données, sans test
    public void update(Client clientToUpdate, Client newDataClient){
            clientToUpdate.setCompanyName(newDataClient.getCompanyName());
            clientToUpdate.setFirstName(newDataClient.getFirstName());
            clientToUpdate.setLastName(newDataClient.getLastName());
            clientToUpdate.setEmail(newDataClient.getEmail());
            clientToUpdate.setPhone(newDataClient.getPhone());
            clientToUpdate.setAddress(newDataClient.getAddress());
            clientToUpdate.setZipCode(newDataClient.getZipCode());
            clientToUpdate.setCity(newDataClient.getCity());
            clientToUpdate.setCountry(newDataClient.getCountry());
            clientToUpdate.setClientState(newDataClient.getClientState());

            clientRepository.save(clientToUpdate);
    }

    // Tests pour valider certaines données
    public String updateValideClient(Client clientToUpdate, Client newDataClient){
        String reponseStr = " ";
        if (newDataClient.getFirstName().isBlank())
           reponseStr+="Le prenom doit être saisi! ";

        clientToUpdate.setFirstName(newDataClient.getFirstName());

        if (newDataClient.getLastName().isBlank())
            reponseStr+="Le nom doit être saisi";

        clientToUpdate.setLastName(newDataClient.getLastName());

        if (newDataClient.getEmail().isBlank())
            reponseStr+="L'email doit être saisi";
        clientToUpdate.setEmail(newDataClient.getEmail());

        if (newDataClient.getPhone().isBlank())
            reponseStr+="Le téléphone doit être saisi";

        clientToUpdate.setPhone(newDataClient.getPhone());

        clientToUpdate.setClientState(newDataClient.getClientState());
        clientToUpdate.setAddress(newDataClient.getAddress());
        clientToUpdate.setCity(newDataClient.getCity());
        clientToUpdate.setCountry(newDataClient.getCountry());

        clientRepository.save(clientToUpdate);

        return reponseStr;
    }

}
