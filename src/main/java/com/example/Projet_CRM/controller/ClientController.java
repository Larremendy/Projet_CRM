package com.example.Projet_CRM.controller;

import com.example.Projet_CRM.dao.ClientRepository;
import com.example.Projet_CRM.model.Client;
import com.example.Projet_CRM.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api")
public class ClientController {
    @Autowired
    ClientService clientService;

    // GET clients
    @GetMapping("clients")
    public List<Client> getAllClients(){
        return clientService.getAll();
    }

    // GET client/i
    @GetMapping("clients/{id}")
    public ResponseEntity<?> getOneById(@PathVariable("id") Integer id){
        Optional<Client> optional = clientService.getOneById(id);
        if(optional.isEmpty()) {
            return ResponseEntity.badRequest().body("id inexistant");
        }
        return ResponseEntity.ok(optional.get());
    }

    // POST clients
    @PostMapping("clients")
    public void addClient(@RequestBody Client newClient){
        clientService.addClient(newClient);
    }


    // DELETE client/i
    @DeleteMapping("clients/{id}")
    public ResponseEntity<String> deleteOneById(@PathVariable("id") Integer id){
        Optional<Client> optional = clientService.getOneById(id);

        if (optional.isEmpty())
            return ResponseEntity.notFound().build();

        Client clientToDelete = optional.get();
        clientService.deleteClient(clientToDelete);
        return ResponseEntity.ok("Suppression réalisée!");

    }


    // PUT client/i
    @PutMapping("clients/{id}")
    public ResponseEntity<String> putClient(@PathVariable("id") Integer id,@RequestBody Client newDataClient){
        Optional<Client> optional = clientService.getOneById(id);
        if(optional.isEmpty())
            return ResponseEntity.notFound().build();

        Client clientToUpdate = optional.get();
        clientService.update(clientToUpdate, newDataClient);
        return ResponseEntity.ok("Update réalisée");
    }


    @PatchMapping("clients/{id}")
    public ResponseEntity<?> patchtClient(@PathVariable("id") Integer id, @RequestBody Client newDataClient){
        Optional<Client> optional = clientService.getOneById(id);

        if(optional.isEmpty())
            return ResponseEntity.notFound().build();

        Client clientToUpdate = optional.get();

        String reponseStr=clientService.updateValideClient(clientToUpdate,newDataClient);
        if (reponseStr.equals(" ")) {
            reponseStr = "Update réalisé!";
            return ResponseEntity.ok(reponseStr);
        } else
            return ResponseEntity.badRequest().body(reponseStr);
    }
}
