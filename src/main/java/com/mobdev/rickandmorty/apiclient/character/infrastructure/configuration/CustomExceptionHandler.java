package com.mobdev.rickandmorty.apiclient.character.infrastructure.configuration;

import com.mobdev.rickandmorty.apiclient.character.core.dto.ErrorDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

/**
 * The type Custom exception handler.
 *
 * @author HugoMartinThielemannMoreno
 */
@RestControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    /**
     * Handle type mismatch response entity.
     *
     * @param ex      the ex
     * @param request the request
     * @return the response entity
     */
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<Object> handleTypeMismatch(MethodArgumentTypeMismatchException ex, WebRequest request) {
        String name = ex.getName();
        Class<?> requiredType = ex.getRequiredType();
        String type = requiredType != null ? requiredType.getSimpleName() : "";
        Object value = ex.getValue();
        String message = String.format("'%s' should be a valid '%s' and '%s' isn't", name, type, value);
        ErrorDto errorDto = new ErrorDto(new Date(), HttpStatus.BAD_REQUEST.value(),
                HttpStatus.BAD_REQUEST.getReasonPhrase(), message,
                ((ServletWebRequest) request).getRequest().getRequestURI());
        return new ResponseEntity<>(errorDto, new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }
}
