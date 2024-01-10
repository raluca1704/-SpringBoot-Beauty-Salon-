package org.salon_frumusete.controller;

import org.salon_frumusete.databasemodell.Client;
import org.salon_frumusete.observer.Observer;
import org.salon_frumusete.observer.Subject;
import org.salon_frumusete.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/clients")
public class ClientController implements Subject {


    @Autowired
    private ClientRepository clientRepository;
    private List<Observer> observers = new ArrayList<>();


    @PostMapping
    public ResponseEntity<Client> addClient(@RequestBody Client client) {
        Client savedClient = clientRepository.save(client);
        return ResponseEntity.ok(savedClient);
    }

    @GetMapping("/{clientId}")
    public ResponseEntity<Client> getClientById(@PathVariable int clientId) {
        return clientRepository.findById(clientId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Client>> getAllClients() {
        for (Client client : clientRepository.findAll()) {
            System.out.println(client.getName());
        }
        return ResponseEntity.ok(clientRepository.findAll());
    }

    @PutMapping("/{clientId}")
    public ResponseEntity<Client> updateClient(@PathVariable int clientId, @RequestBody Client clientDetails) {
        return clientRepository.findById(clientId)
                .map(client -> {
                    client.setName(clientDetails.getName());
                    client.setEmail(clientDetails.getEmail());
                    client.setTelephoneNumber(clientDetails.getTelephoneNumber());
                    return ResponseEntity.ok(clientRepository.save(client));
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{clientId}")
    public ResponseEntity<Void> deleteClient(@PathVariable int clientId) {
        return clientRepository.findById(clientId)
                .map(client -> {
                    clientRepository.delete(client);
                    return ResponseEntity.ok().<Void>build();
                }).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/search")
    public ResponseEntity<List<Client>> getClientsByName(@RequestParam String name) {
        return ResponseEntity.ok(clientRepository.findByNameContaining(name));
    }
    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }

}