package com.mobdev.rickandmorty.apiclient.character.api.service;

import com.mobdev.rickandmorty.apiclient.character.api.usecase.FindCharacterByIdUseCase;
import com.mobdev.rickandmorty.apiclient.character.core.dto.OriginDto;
import com.mobdev.rickandmorty.apiclient.character.core.dto.RootDto;
import com.mobdev.rickandmorty.apiclient.character.core.model.Character;
import com.mobdev.rickandmorty.apiclient.character.core.model.Detail;
import com.mobdev.rickandmorty.apiclient.character.core.model.Location;
import com.mobdev.rickandmorty.apiclient.character.infrastructure.client.RickAndMortyApiClient;
import lombok.Generated;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * The type Find character by id service.
 *
 * @author HugoMartinThielemannMoreno
 */
@Service
@RequiredArgsConstructor
public class FindCharacterByIdService implements FindCharacterByIdUseCase {
    private final RickAndMortyApiClient client;
    private final ModelMapper mapper;

    @Override
    public RootDto findById(Integer id) {
        Character character = client.findCharacterById(id);
        RootDto dto = mapper.map(character, RootDto.class);
        dto.setEpisodeCount(character.getEpisode().stream().count());
        Optional<Integer> optional = getLocationIdByOrigin(character.getOrigin());
        if (optional.isPresent()) {
            Location location = client.findLocationById(optional.get());
            OriginDto originDto = dto.getOrigin();
            originDto.setDimension(location.getDimension());
            originDto.setResidents(location.getResidents());
        }
        return dto;
    }

    @Generated
    private Optional<Integer> getLocationIdByOrigin(Detail origin) {
        if (origin == null) {
            return Optional.empty();
        }
        String url = origin.getUrl();
        if (url == null || url.strip().isBlank()) {
            return Optional.empty();
        }
        String idString = url.substring(url.lastIndexOf("/") + 1);
        return convertStringToInteger(idString);
    }

    @Generated
    private Optional<Integer> convertStringToInteger(String s) {
        if (s == null) {
            return Optional.empty();
        }
        s = s.strip();
        if (s.isBlank()) {
            return Optional.empty();
        }
        try {
            return Optional.of(Integer.valueOf(s));
        } catch (NumberFormatException e) {
            return Optional.empty();
        }
    }

}
