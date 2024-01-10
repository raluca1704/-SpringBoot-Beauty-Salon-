package org.salon_frumusete.controller;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import org.salon_frumusete.Main;
import org.salon_frumusete.databasemodell.Client;
import org.salon_frumusete.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

@SpringBootTest(classes = Main.class)
@AutoConfigureMockMvc
@AutoConfigureTestDatabase
@ActiveProfiles("test")
class DummyController {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ClientRepository clientRepository;


    @Test
    void shouldReturnDefaultMessage() throws Exception {

        Client client = new Client();
        client.setClientID(101);
        client.setName("raluca");
        client.setEmail("wwww");
        client.setTelephoneNumber("03938493");
        clientRepository.save(client);
        Client foundClient = clientRepository.findById(101).orElse(null);
        Assertions.assertNotNull(foundClient);
        Assertions.assertEquals(client.getName(), foundClient.getName());

        this.mockMvc.perform(get("/api/clients/{clientId}", 101))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString( client.getName())))
              ;


    }
    @Test
    void shouldReturn() throws Exception {

//        Client client = new Client();
//        client.setClientID(101);
//        client.setName("raluca");
//        client.setEmail("wwww");
//        client.setTelephoneNumber("03938493");
//        clientRepository.save(client);


        MvcResult postResult = mockMvc.perform(
                        post("/api/clients")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content("{\"clientID\":101,\"name\":\"raluca\",\"email\":\"wwww\",\"telephoneNumber\":\"03938493\"}")
                )
                .andExpect(status().isOk())
                .andReturn();

//
//        Client foundClient = clientRepository.findById(101).orElse(null);
//        Assertions.assertNotNull(foundClient);
//        Assertions.assertEquals(client.getName(), foundClient.getName());
//
//
//        MvcResult getResult = mockMvc.perform(get("/api/clients/{clientId}", 101))
//                .andDo(print()).andExpect(status().isOk())
//                .andExpect(content().string(containsString(client.getName())))
//                .andReturn();
    }




    }

