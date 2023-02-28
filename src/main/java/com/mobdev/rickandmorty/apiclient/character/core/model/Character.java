package com.mobdev.rickandmorty.apiclient.character.core.model;

import lombok.Data;

import java.util.List;

/**
 * The type Character.
 *
 * @author HugoMartinThielemannMoreno
 */
@Data
public class Character {
    private String created;
    private List<String> episode;
    private String gender;
    private Long id;
    private String image;
    private Detail location;
    private String name;
    private Detail origin;
    private String species;
    private String status;
    private String type;
    private String url;
}
