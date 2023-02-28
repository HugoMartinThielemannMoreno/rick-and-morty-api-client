package com.mobdev.rickandmorty.apiclient.character.api.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mobdev.rickandmorty.apiclient.character.core.dto.RootDto;
import com.mobdev.rickandmorty.apiclient.character.core.model.Character;
import com.mobdev.rickandmorty.apiclient.character.core.model.Location;
import com.mobdev.rickandmorty.apiclient.character.infrastructure.client.RickAndMortyApiClient;
import lombok.SneakyThrows;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;

import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FindCharacterByIdServiceTest {
    @Mock
    RickAndMortyApiClient client;
    @Mock
    ModelMapper mapper;
    @InjectMocks
    FindCharacterByIdService service;
    Path path;
    ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        path = Path.of("", "src/test/resources");
        objectMapper = new ObjectMapper();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void findById_withLocation() {
        Mockito.when(client.findCharacterById(Mockito.any(Integer.class))).thenReturn(getCharacter(true));
        Mockito.when(mapper.map(Mockito.any(Character.class), Mockito.eq(RootDto.class))).thenReturn(getRootDto());
        Mockito.when(client.findLocationById(Mockito.any(Integer.class))).thenReturn(getLocation());
        RootDto actual = service.findById(1);
        assertEquals(getExpectedRootDto(true), actual);
    }

    @Test
    void findById_withoutLocation() {
        Mockito.when(client.findCharacterById(Mockito.any(Integer.class))).thenReturn(getCharacter(false));
        Mockito.when(mapper.map(Mockito.any(Character.class), Mockito.eq(RootDto.class))).thenReturn(getRootDto());
        RootDto actual = service.findById(1);
        assertEquals(getExpectedRootDto(false), actual);
    }

    @SneakyThrows
    Character getCharacter(boolean withOrigin) {
        Path file;
        if (withOrigin) {
            file = path.resolve("character.json");
        } else {
            file = path.resolve("character-without-origin.json");
        }
        String content = Files.readString(file);
        return objectMapper.readValue(content, Character.class);
    }

    @SneakyThrows
    RootDto getRootDto() {
        Path file = path.resolve("root.json");
        String content = Files.readString(file);
        return objectMapper.readValue(content, RootDto.class);
    }

    @SneakyThrows
    RootDto getExpectedRootDto(boolean withOriginDetails) {
        Path file;
        if (withOriginDetails) {
            file = path.resolve("expected-root.json");
        } else {
            file = path.resolve("expected-without-origin-details-root.json");
        }
        String content = Files.readString(file);
        return objectMapper.readValue(content, RootDto.class);
    }

    @SneakyThrows
    Location getLocation() {
        Path file = path.resolve("location.json");
        String content = Files.readString(file);
        return objectMapper.readValue(content, Location.class);
    }
}
