package com.mobdev.rickandmorty.apiclient.character.infrastructure.client;

import com.mobdev.rickandmorty.apiclient.character.core.model.Character;
import com.mobdev.rickandmorty.apiclient.character.core.model.Location;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * The interface Rick and morty api client.
 *
 * @author HugoMartinThielemannMoreno
 */
@FeignClient(name = "rickandmortyapiclient", url = "https://rickandmortyapi.com/api")
public interface RickAndMortyApiClient {
    /**
     * Find character by id character.
     *
     * @param id the id
     * @return the character
     */
    @GetMapping("/character/{id}")
    Character findCharacterById(@PathVariable Integer id);

    /**
     * Find location by id location.
     *
     * @param id the id
     * @return the location
     */
    @GetMapping("/location/{id}")
    Location findLocationById(@PathVariable Integer id);
}
