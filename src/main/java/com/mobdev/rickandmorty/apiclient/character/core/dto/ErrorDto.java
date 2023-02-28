package com.mobdev.rickandmorty.apiclient.character.core.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * The type Error dto.
 *
 * @author HugoMartinThielemannMoreno
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDto {
    private Date timestamp;
    private Integer status;
    private String error;
    private String message;
    private String path;
}
