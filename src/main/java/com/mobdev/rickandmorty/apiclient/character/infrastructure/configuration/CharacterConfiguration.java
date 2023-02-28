package com.mobdev.rickandmorty.apiclient.character.infrastructure.configuration;

import com.mobdev.rickandmorty.apiclient.character.infrastructure.configuration.openfeign.CustomErrorDecoder;
import feign.codec.ErrorDecoder;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * The type Character configuration.
 *
 * @author HugoMartinThielemannMoreno
 */
@Configuration
public class CharacterConfiguration {
    /**
     * Model mapper model mapper.
     *
     * @return the model mapper
     */
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    /**
     * Error decoder error decoder.
     *
     * @return the error decoder
     */
    @Bean
    public ErrorDecoder errorDecoder() {
        return new CustomErrorDecoder();
    }
}
