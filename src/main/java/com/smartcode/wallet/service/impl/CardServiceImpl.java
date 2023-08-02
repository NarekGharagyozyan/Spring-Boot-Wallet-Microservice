package com.smartcode.wallet.service.impl;

import com.smartcode.wallet.exceptions.DuplicationException;
import com.smartcode.wallet.exceptions.ResourceNotFoundException;
import com.smartcode.wallet.mapper.CardMapper;
import com.smartcode.wallet.model.dto.CardRequestDto;
import com.smartcode.wallet.model.dto.CardResponseDto;
import com.smartcode.wallet.model.entity.CardEntity;
import com.smartcode.wallet.repository.CardRepository;
import com.smartcode.wallet.service.CardService;
import com.smartcode.wallet.util.constants.Message;
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
        if (cardRepository.findByNumber(cardRequestDto.getNumber()) != null) {
            throw new DuplicationException(Message.CARD_WITH_NUMBER_ALREADY_EXISTS);
        }
        CardEntity entity = cardMapper.toEntity(cardRequestDto);
        CardEntity save = cardRepository.save(entity);
        return cardMapper.toDto(save);
    }

    @Override
    @Transactional
    public void deleteAllByOwnerId(Integer userId) {
        if (cardRepository.findAllByOwnerId(userId) == null) {
            throw new ResourceNotFoundException(Message.USER_NOT_FOUND);
        }
        cardRepository.deleteAllByOwnerId(userId);
    }

    @Override
    public void deleteByCardId(Integer cardId) {
        CardEntity cardEntity = cardRepository.findById(cardId).orElseThrow(() -> new ResourceNotFoundException(Message.CARD_NOT_FOUND));
        cardRepository.delete(cardEntity);
    }

    @Override
    @Transactional
    public List<CardResponseDto> findByUserId(Integer userId) {
        if (cardRepository.findAllByOwnerId(userId) == null) {
            throw new ResourceNotFoundException(Message.USER_NOT_FOUND);
        }
        List<CardEntity> cards = cardRepository.findAllByOwnerId(userId);
        return cardMapper.toDtoList(cards);
    }
}
