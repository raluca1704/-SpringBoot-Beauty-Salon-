//package org.salon_frumusete.repository;
//
//
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.salon_frumusete.databasemodell.Client;
//import org.salon_frumusete.repository.ClientRepository;
//import org.salon_frumusete.repository.SqlServer;
//
//import java.sql.Connection;
//import java.sql.SQLException;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//public class ConnTest {
//
//    @Test
//    void testDatabaseConnection() {
//        try (Connection connection = SqlServer.conn()) {
//
//            assertNotNull(connection, "Database connection is not null");
//
//            assertTrue(connection.isValid(1), "Database connection is valid");
//        } catch (SQLException e) {
//            fail("Exception while testing database connection: " + e.getMessage());
//        }
//    }
////    @Test
////    void testaddclient() {
////        ClientRepository clientRepository = new ClientRepository();
////        Client clientotadd = new Client();
////        clientotadd.setClientID(1222);
////        clientotadd.setTelephoneNumber("phonetest");
////        clientotadd.setEmail("emailtest");
////        clientotadd.setName("test");
////        clientRepository.addClient(clientotadd);
////
////        int lastIndex = clientRepository.getAllClients().size() - 1;
////        Client lastclient = clientRepository.getAllClients().get(lastIndex);
////
////        assertEquals(lastclient.getName(), clientotadd.getName());
////        System.out.println("test passed");
////
////
////    }
////    @Test
////    void testUpdateClient() {
////
////        ClientRepository clientRepository = new ClientRepository();
////        Client originalClient = new Client();
////        originalClient.setClientID(1223);
////        originalClient.setTelephoneNumber("originalTelephoneNumber");
////        originalClient.setEmail("originalEmail");
////        originalClient.setName("originalName");
////
////
////
////        clientRepository.addClient(originalClient);
////
////        Client updatedClient = new Client();
////        updatedClient.setClientID(originalClient.getClientID());
////        updatedClient.setTelephoneNumber("updatedTelephoneNumber");
////        updatedClient.setEmail("updatedEmail");
////        updatedClient.setName("updatedName");
////
////        clientRepository.updateClient(updatedClient);
////
////
////        Client retrievedClient = clientRepository.getClientById(originalClient.getClientID());
////
////        assertEquals(updatedClient.getTelephoneNumber(), retrievedClient.getTelephoneNumber(),
////                "TelephoneNumber should be updated");
////        assertEquals(updatedClient.getEmail(), retrievedClient.getEmail(),
////                "Email should be updated");
////        assertEquals(updatedClient.getName(), retrievedClient.getName(),
////                "Name should be updated");
////    }
//}
//
//
