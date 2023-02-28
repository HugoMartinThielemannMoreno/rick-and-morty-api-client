package com.mobdev.rickandmorty.apiclient.character.api.usecase;

import com.mobdev.rickandmorty.apiclient.character.core.dto.RootDto;

/**
 * The interface Find character by id use case.
 *
 * @author HugoMartinThielemannMoreno
 */
public interface FindCharacterByIdUseCase {
    /**
     * Find by id root dto.
     *
     * @param id the id
     * @return the root dto
     */
    RootDto findById(Integer id);
}
