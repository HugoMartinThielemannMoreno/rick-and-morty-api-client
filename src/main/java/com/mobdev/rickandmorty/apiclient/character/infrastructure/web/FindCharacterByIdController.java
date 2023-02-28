package com.mobdev.rickandmorty.apiclient.character.infrastructure.web;

import com.mobdev.rickandmorty.apiclient.character.api.usecase.FindCharacterByIdUseCase;
import com.mobdev.rickandmorty.apiclient.character.core.dto.RootDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type Find character by id controller.
 *
 * @author HugoMartinThielemannMoreno
 */
@RestController
@RequiredArgsConstructor
public class FindCharacterByIdController {
    private final FindCharacterByIdUseCase useCase;

    /**
     * Find by id root dto.
     *
     * @param id the id
     * @return the root dto
     */
    @GetMapping(value = "/api/characters/{id}")
    public RootDto findById(@PathVariable Integer id) {
        return useCase.findById(id);
    }
}
