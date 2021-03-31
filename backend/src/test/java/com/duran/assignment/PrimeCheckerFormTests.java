package com.duran.assignment;

import com.duran.assignment.models.PrimeCheckerForm;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

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

    /**
     * The name of the JSON field containing the answer
     */
    private final String isPrimeFieldName = "isPrime";

    @Test
    public void givenNoFormData_thenStatus400() throws Exception {
        mockMvc.perform(post(route)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void givenNumber_asString_thenStatus200() throws Exception {
        PrimeCheckerForm formContent = new PrimeCheckerForm(0);

        mockMvc.perform(post(route)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(formContent)))
                .andExpect(status().isOk());
    }

    @Test
    public void givenNumber_asInt_thenStatus200() throws Exception {
        PrimeCheckerForm formContent = new PrimeCheckerForm(0);

        mockMvc.perform(post(route)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(formContent)))
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

    @Test
    public void givenPrimeNumber_thenShouldTrue() throws Exception {
        int[] testNumbers = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 112909};

        for (int number: testNumbers) {
            assertResponseIsOk(number, true);
        }
    }

    /**
     * Send a mocked and valid POST request containing a number.
     * Then asserts that the JSON response is valid and corresponds to the given boolean.
     *
     * @param  number  the number to send in the JSON
     * @param  shouldBePrime indicates whether we expect the server to answer true or false in the "isPrime" field
     */
    private void assertResponseIsOk(int number, boolean shouldBePrime) throws Exception {
        PrimeCheckerForm formContent = new PrimeCheckerForm(number);

        mockMvc.perform(post(route)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(formContent)))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath(isPrimeFieldName, is(shouldBePrime)));
    }

}
