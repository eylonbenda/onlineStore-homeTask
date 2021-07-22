package com.homeTask.onlineStore;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.homeTask.onlineStore.controllers.StoreController;
import com.homeTask.onlineStore.modal.Groceris;
import com.homeTask.onlineStore.modal.OrderRequest;
import com.homeTask.onlineStore.services.StoreService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import java.util.ArrayList;
import java.util.List;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(StoreController.class)
class StoreControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StoreService storeService;

    @Test
    void setOrder() throws Exception {

        List<Groceris> grocerises = new ArrayList<>();
        grocerises.add(new Groceris
                ("Nutiva, Organic Hemp Seed, Raw Shelled, 19 oz (539 g)", "1"));
        OrderRequest orderRequest = new OrderRequest();

        mockMvc.perform( MockMvcRequestBuilders
                .post("http://localhost:8882/api/v1/order")
                .content(asJsonString(orderRequest))
                .accept(MediaType.ALL)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}