package org.salon_frumusete.controller;

import org.salon_frumusete.databasemodell.Client;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DummyController {

    @GetMapping("/test")
    public String testEndpoint() {
        return "Test successful!";
}
    @GetMapping("/testClient")
    public ResponseEntity<Client> testClientEndpoint() {

        Client client = new Client();
        client.setClientID(1);
        client.setName("Test Name");
        client.setEmail("test@example.com");
        client.setTelephoneNumber("123-456-7890");

        return ResponseEntity.ok(client);
}
}