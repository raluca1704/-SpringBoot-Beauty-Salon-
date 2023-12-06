package org.salon_frumusete.controller;

import org.salon_frumusete.databasemodell.Client;
import org.salon_frumusete.repository.ClientRepository;

import java.util.List;

public class ClientController {
    private ClientRepository clientRepository;

    public ClientController(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public void addClient(Client client) {
        clientRepository.addClient(client);
    }

    public Client getClientById(int clientID) {
        return clientRepository.getClientById(clientID);
    }

    public List<Client> getAllClients() {
        return clientRepository.getAllClients();
    }

    public void updateClient(Client updatedClient) {
        clientRepository.updateClient(updatedClient);
    }

    public void deleteClient(int clientID) {
        clientRepository.deleteClient(clientID);
    }
    public Client getClientByName(String name) {
        return clientRepository.getClientByName(name);
    }

}
