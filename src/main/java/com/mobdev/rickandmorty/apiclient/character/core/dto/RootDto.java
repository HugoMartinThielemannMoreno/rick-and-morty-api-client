package com.mobdev.rickandmorty.apiclient.character.core.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * The type Root dto.
 *
 * @author HugoMartinThielemannMoreno
 */
@Data
public class RootDto {
    private Long id;
    private String name;
    private String status;
    private String species;
    private String type;
    private OriginDto origin;
    @JsonProperty("episode_count")
    private Long episodeCount;
}
