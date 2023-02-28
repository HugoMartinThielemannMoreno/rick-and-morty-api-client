package com.mobdev.rickandmorty.apiclient.character.infrastructure.configuration.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * The type Jackson configuration.
 *
 * @author HugoMartinThielemannMoreno
 */
@Configuration
@RequiredArgsConstructor
public class JacksonConfiguration {
    private final ObjectMapper objectMapper;

    /**
     * Sets object mapper.
     */
    @PostConstruct
    public void setObjectMapper() {
        objectMapper.setAnnotationIntrospector(new NullToEmptyJacksonAnnotationIntrospector());
    }
}
