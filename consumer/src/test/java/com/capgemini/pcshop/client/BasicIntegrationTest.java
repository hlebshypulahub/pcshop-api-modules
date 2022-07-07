package com.capgemini.pcshop.client;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
@AutoConfigureStubRunner(
        ids = "com.capgemini:producer:+:stubs:8090",
        stubsMode = StubRunnerProperties.StubsMode.LOCAL
)
public class BasicIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldReturnParts() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/parts")
                                              .param("id", String.valueOf(1))
                                              .contentType(MediaType.APPLICATION_JSON))
               .andExpect(status().isOk())
               .andExpect(content().json("    {\n" +
                       "        \"id\": 1,\n" +
                       "        \"name\": \"Laptop\",\n" +
                       "        \"producerCode\": \"48239523\"\n" +
                       "    }"));
    }
}
