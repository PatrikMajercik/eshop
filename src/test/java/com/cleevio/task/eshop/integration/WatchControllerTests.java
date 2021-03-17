package com.cleevio.task.eshop.integration;

import com.cleevio.task.eshop.API.WatchController;
import com.cleevio.task.eshop.API.WatchDTO;
import com.cleevio.task.eshop.dao.Watch;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.apache.tomcat.util.codec.binary.Base64;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@AutoConfigureMockMvc
@SpringBootTest
public class WatchControllerTests {

    @Autowired
    private WatchController watchController;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    private final XmlMapper xmlMapper = new XmlMapper();

    private Watch watchWithNullId;
    private WatchDTO watchDTOWithNullId;

    @BeforeEach
    public void tearUp() {
        watchWithNullId = Watch.builder()
                .id(null)
                .title("Random title 1")
                .price(120)
                .image(("Random image1".getBytes()))
                .description("Random desc 1")
                .build();

        watchDTOWithNullId = WatchDTO.builder()
                .id(watchWithNullId.getId())
                .title(watchWithNullId.getTitle())
                .price(watchWithNullId.getPrice())
                .imageBase64(Base64.encodeBase64String(watchWithNullId.getImage()))
                .description(watchWithNullId.getDescription())
                .build();
    }

    @Test
    void createWatchJSON_shouldCreateAndReturnCreated_whenEntityIsValidWithNullId() throws Exception {
        mockMvc.perform(post("/api/watch/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(watchDTOWithNullId)))
                .andExpect(status().isCreated());
    }

    @Test
    void createWatchJSON_shouldCreateAndReturnBadRequest_whenEntityIsNotValidWithNonNullId() throws Exception {
        watchDTOWithNullId.setId(23L);
        mockMvc.perform(post("/api/watch/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(watchDTOWithNullId)))
                .andExpect(status().isBadRequest());
    }

    @Test
    void createWatchJSON_shouldCreateAndReturnBadRequest_whenEntityIsNotValidWithNullImage() throws Exception {
        watchDTOWithNullId.setImageBase64(null);
        mockMvc.perform(post("/api/watch/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(watchDTOWithNullId)))
                .andExpect(status().isBadRequest());
    }

    @Test
    void createWatchCML_shouldCreateAndReturnCreated_whenEntityIsValidWithNullId() throws Exception {
        mockMvc.perform(post("/api/watch/create")
                .contentType(MediaType.APPLICATION_XML_VALUE)
                .content(xmlMapper.writeValueAsString(watchDTOWithNullId)))
                .andExpect(status().isCreated());
    }

    @Test
    void createAndRetrieveWatchJSON_shouldCreateAndReturnCreatedAndRetrieve_whenEntityIsValidWithNullId() throws Exception {
        String responseCreateBodyBody = mockMvc.perform(post("/api/watch/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(watchDTOWithNullId)))
                .andExpect(status().isCreated())
                .andReturn().getResponse().getContentAsString();

        watchDTOWithNullId = objectMapper.readValue(responseCreateBodyBody, WatchDTO.class);

        String responseBody = mockMvc.perform(get("/api/watch/find/{id}", watchDTOWithNullId.getId())
                .contentType(MediaType.APPLICATION_JSON))
                .andReturn().getResponse().getContentAsString();

        WatchDTO responseWatchDTO = objectMapper.readValue(responseBody, WatchDTO.class);
        assertThat(responseWatchDTO).isEqualTo(watchDTOWithNullId);

    }
}
