package es.inditex.commerce.controller;

import es.inditex.commerce.exception.NotRecordFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ActiveProfiles("test")
@SpringBootTest
@AutoConfigureMockMvc
public class PricesControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void test1() throws Exception {

        var payload = """
                    {
                           "startDate": "2020-06-14 10.00.00",
                           "productId": 35455,
                           "brandId": 1
                    }
                """;

        this.mockMvc.perform(get("/prices/find-by-query")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payload))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.price", equalTo(38.95)));
    }

    @Test
    void test2() throws Exception {

        var payload = """
                    {
                           "startDate": "2020-06-14 16.00.00",
                           "productId": 35455,
                           "brandId": 1
                    }
                """;

        this.mockMvc.perform(get("/prices/find-by-query")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payload))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.price", equalTo(38.95)));
    }

    @Test
    void test3() throws Exception {

        var payload = """
                    {
                           "startDate": "2020-06-14 21.00.00",
                           "productId": 35455,
                           "brandId": 1
                    }
                """;

        this.mockMvc.perform(get("/prices/find-by-query")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payload))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.price", equalTo(38.95)));
    }

    @Test
    void test4() throws Exception {

        var payload = """
                    {
                           "startDate": "2020-06-15 10.00.00",
                           "productId": 35455,
                           "brandId": 1
                    }
                """;

        this.mockMvc.perform(get("/prices/find-by-query")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payload))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.price", equalTo(38.95)));
    }

    @Test
    void test5() throws Exception {

        var payload = """
                    {
                           "startDate": "2020-06-16 21.00.00",
                           "productId": 35455,
                           "brandId": 1
                    }
                """;

        this.mockMvc.perform(get("/prices/find-by-query")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payload))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof NotRecordFoundException))
                .andExpect(result -> assertEquals("Not records found", result.getResolvedException().getMessage()));
    }

}
