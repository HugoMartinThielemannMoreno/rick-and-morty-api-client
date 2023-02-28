package com.mobdev.rickandmorty.apiclient.character.core.model;

import lombok.Data;

import java.util.List;

/**
 * The type Location.
 *
 * @author HugoMartinThielemannMoreno
 */
@Data
public class Location {
    private String dimension;
    private List<String> residents;
}
