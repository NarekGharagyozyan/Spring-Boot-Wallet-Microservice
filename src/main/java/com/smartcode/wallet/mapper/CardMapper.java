package com.smartcode.wallet.mapper;

import com.smartcode.wallet.model.dto.CardRequestDto;
import com.smartcode.wallet.model.dto.CardResponseDto;
import com.smartcode.wallet.model.entity.CardEntity;
import org.mapstruct.Mapper;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CardMapper {
    CardEntity toEntity(CardRequestDto cardRequestDto);

    CardResponseDto toDto(CardEntity cardEntity);

    List<CardResponseDto> toDtoList (List<CardEntity> cardEntities);
}
