package com.smartcode.wallet.service.impl;

import com.smartcode.wallet.mapper.CardMapper;
import com.smartcode.wallet.model.dto.CardRequestDto;
import com.smartcode.wallet.model.dto.CardResponseDto;
import com.smartcode.wallet.model.entity.CardEntity;
import com.smartcode.wallet.repository.CardRepository;
import com.smartcode.wallet.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CardServiceImpl implements CardService {

    private final CardRepository cardRepository;
    private final CardMapper cardMapper;

    @Override
    @Transactional
    public CardResponseDto create(CardRequestDto cardRequestDto) {
        CardEntity entity = cardMapper.toEntity(cardRequestDto);
        CardEntity save = cardRepository.save(entity);
        return cardMapper.toDto(save);
    }

    @Override
    @Transactional
    public void deleteAllByOwnerId(Integer userId) {
        cardRepository.deleteAllByOwnerId(userId);
    }

    @Override
    public void deleteByCardId(Integer cardId) {
        cardRepository.deleteById(cardId);
    }

    @Override
    @Transactional
    public List<CardResponseDto> findByUserId(Integer userId) {
        List<CardEntity> cards = cardRepository.findAllByOwnerId(userId);
        return cardMapper.toDtoList(cards);
    }
}
