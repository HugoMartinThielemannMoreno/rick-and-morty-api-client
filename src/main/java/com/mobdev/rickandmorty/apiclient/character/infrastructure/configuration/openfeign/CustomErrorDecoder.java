package com.mobdev.rickandmorty.apiclient.character.infrastructure.configuration.openfeign;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mobdev.rickandmorty.apiclient.character.core.exception.ResourceNotFoundException;
import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

/**
 * The type Custom error decoder.
 *
 * @author HugoMartinThielemannMoreno
 */
@Slf4j
public class CustomErrorDecoder implements ErrorDecoder {

    @Override
    public Exception decode(String s, Response response) {
        String message;
        InputStream inputStream = null;
        try {
            inputStream = response.body().asInputStream();
            Map<String, String> error = new ObjectMapper().readValue(response.body().asInputStream(), Map.class);
            message = error.get("error");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    log.error(e.getMessage());
                }
            }
        }
        if (response.status() == 404) {
            return new ResourceNotFoundException(message);
        }
        return new Exception(message);
    }
}