package com.mobdev.rickandmorty.apiclient.character.core.dto;

import lombok.Data;

import java.util.List;

/**
 * The type Origin dto.
 *
 * @author HugoMartinThielemannMoreno
 */
@Data
public class OriginDto {
    private String name;
    private String url;
    private String dimension;
    private List<String> residents;
}
