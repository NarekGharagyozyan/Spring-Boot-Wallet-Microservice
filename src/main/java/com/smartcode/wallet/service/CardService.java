package com.smartcode.wallet.service;

import com.smartcode.wallet.model.dto.CardRequestDto;
import com.smartcode.wallet.model.dto.CardResponseDto;

import java.util.List;

public interface CardService {

    CardResponseDto create(CardRequestDto cardRequestDto);

    List<CardResponseDto> findByUserId (Integer userId);

    void deleteAllByOwnerId(Integer ownerId);

    void deleteByCardId(Integer cardId);
}
