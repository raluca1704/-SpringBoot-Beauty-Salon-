package repository;

import databasemodell.Client;

import java.util.ArrayList;
import java.util.List;

public class ClientRepository {
    private List<Client> clients;

    public ClientRepository() {
        this.clients = new ArrayList<>();
    }

    public void addClient(Client client) {
        clients.add(client);
    }

    public Client getClientById(int clientID) {
        for (Client client : clients) {
            if (client.getClientID() == clientID) {
                return client;
            }
        }
        return null; // databasemodell.Client not found
    }

    public List<Client> getAllClients() {
        return new ArrayList<>(clients); // Return a copy to avoid modifying the internal list
    }

    public void updateClient(Client updatedClient) {
        for (int i = 0; i < clients.size(); i++) {
            if (clients.get(i).getClientID() == updatedClient.getClientID()) {
                clients.set(i, updatedClient);
                return;
            }
        }
    }

    public void deleteClient(int clientID) {
        clients.removeIf(client -> client.getClientID() == clientID);
    }
}
