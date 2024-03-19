package org.jetbrains.assignment;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class RobotControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testLocationsEndpoint() throws Exception {
        String jsonRequest = "[{\"direction\":\"EAST\",\"steps\":1},{\"direction\":\"NORTH\",\"steps\":3}]";
        String expectedResponse = "[{\"x\":0,\"y\":0},{\"x\":1,\"y\":0},{\"x\":1,\"y\":3}]";

        mockMvc.perform(
                post("/locations")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(jsonRequest))
            .andExpect(status().isOk())
            .andExpect(content().json(expectedResponse));
    }

    @Test
    public void testMovesEndpoint() throws Exception {
        String jsonRequest = "[{\"x\":0,\"y\":0},{\"x\":1,\"y\":0},{\"x\":1,\"y\":3}]";
        String expectedResponse = "[{\"direction\":\"EAST\",\"steps\":1},{\"direction\":\"NORTH\",\"steps\":3}]";

        mockMvc.perform(
                post("/moves")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(jsonRequest))
            .andExpect(status().isOk())
            .andExpect(content().json(expectedResponse));
    }
}