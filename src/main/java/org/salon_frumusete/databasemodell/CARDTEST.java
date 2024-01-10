package org.salon_frumusete.databasemodell;

import org.junit.jupiter.api.Test;
import org.salon_frumusete.controller.LoyaltyCardController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(controllers = LoyaltyCardController.class)
@AutoConfigureMockMvc
public class CARDTEST{

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testAddLoyaltyCard() throws Exception {

        ResultActions resultActions = mockMvc.perform(post("/api/loyaltycards")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"loyaltyCardID\":1,\"clientID\":1,\"discount\":0.1}"));
        resultActions.andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.loyaltyCardID").exists())
                .andExpect(jsonPath("$.clientID").value(1))
                .andExpect(jsonPath("$.discount").value(0.1));
    }
}
