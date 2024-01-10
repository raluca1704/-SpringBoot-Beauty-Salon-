//package org.salon_frumusete.controller;
//
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.salon_frumusete.databasemodell.Client;
//import org.salon_frumusete.repository.ClientRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//
//import static org.hamcrest.Matchers.containsString;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//@RunWith(SpringRunner.class)
//@SpringBootTest
//@AutoConfigureMockMvc
//public class controllertest {
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Autowired
//    private ClientRepository clientRepository;
//
//    int clientId = 1;
//    String expectedName = "aaaaa";
//    @Test
//    void shouldReturnDefaultMessage() throws Exception {
//
//        Client foundClient = clientRepository.findById(clientId).orElse(null);
//        Assertions.assertNotNull(foundClient);
//        Assertions.assertEquals(expectedName, foundClient.getName());
//
//        this.mockMvc.perform(get("/api/clients/{clientId}", clientId))
//                .andDo(print()).andExpect(status().isOk())
//                .andExpect(content().string(containsString( expectedName)))
//        ;
//
//
//    }
//}
