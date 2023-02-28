package com.mobdev.rickandmorty.apiclient.character.infrastructure.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mobdev.rickandmorty.apiclient.character.api.usecase.FindCharacterByIdUseCase;
import com.mobdev.rickandmorty.apiclient.character.core.dto.RootDto;
import com.mobdev.rickandmorty.apiclient.character.infrastructure.configuration.jackson.NullToEmptyJacksonAnnotationIntrospector;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@WebMvcTest(FindCharacterByIdController.class)
class FindCharacterByIdControllerTest {
    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper customObjectMapper;
    @MockBean
    FindCharacterByIdUseCase useCase;
    Path path;
    ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        path = Path.of("", "src/test/resources/web");
        objectMapper = new ObjectMapper();
        customObjectMapper.setAnnotationIntrospector(new NullToEmptyJacksonAnnotationIntrospector());
    }

    @Test
    void findById() throws Exception {
        when(useCase.findById(any(Integer.class))).thenReturn(getRootDto());
        String actual = mockMvc.perform(MockMvcRequestBuilders.get("/api/characters/{id}", 1))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn().getResponse().getContentAsString();
        RootDto result = customObjectMapper.readValue(actual, RootDto.class);
        RootDto expected = getRootDtoExpected();
        assertEquals(expected, result);
    }

    RootDto getRootDto() throws IOException {
        Path file = path.resolve("without-origin-details-root.json");
        String content = Files.readString(file);
        return objectMapper.readValue(content, RootDto.class);
    }

    RootDto getRootDtoExpected() throws IOException {
        Path file = path.resolve("expected-root.json");
        String content = Files.readString(file);
        return objectMapper.readValue(content, RootDto.class);
    }
}
