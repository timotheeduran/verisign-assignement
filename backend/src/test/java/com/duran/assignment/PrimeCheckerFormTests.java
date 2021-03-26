package com.duran.assignment;

import com.duran.assignment.models.PrimeCheckerForm;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class PrimeCheckerFormTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    /**
     * The route of the form
     */
    private final String route = "/checker";

    @Test
    public void givenNoFormData_thenStatus400() throws Exception {
        mockMvc.perform(post(route)
                .contentType("application/json"))
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void givenNumber_asString_thenStatus200() throws Exception {
        mockMvc.perform(post(route)
                .contentType("application/json")
                .content("{\"number\":\"0\"}"))
                .andExpect(status().isOk());
    }

    @Test
    public void givenNumber_asInt_thenStatus200() throws Exception {
        mockMvc.perform(post(route)
                .contentType("application/json")
                .content("{\"number\":0}"))
                .andExpect(status().isOk());
    }

    @Test
    public void givenNegativeNumber_thenShouldReturnFalse() throws Exception {
        int[] testNumbers = {-1, -246, -76845487};

        for (int number: testNumbers) {
            assertResponseIsOk(number, false);
        }
    }

    @Test
    public void givenNonPrimeNumber_thenShouldReturnFalse() throws Exception {
        int[] testNumbers = {1, 54, 87};

        for (int number: testNumbers) {
            assertResponseIsOk(number, false);
        }
    }

    private void assertResponseIsOk(int number, boolean shouldBePrime) throws Exception {
        PrimeCheckerForm formContent = new PrimeCheckerForm(number);

        mockMvc.perform(post(route)
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(formContent)))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("isPrime", is(false)));
    }

}
