package com.smartcode.wallet.controller;

import com.smartcode.wallet.model.dto.CardRequestDto;
import com.smartcode.wallet.model.dto.CardResponseDto;
import com.smartcode.wallet.model.entity.CardEntity;
import com.smartcode.wallet.service.CardService;
import com.smartcode.wallet.util.constants.Path;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(Path.CARDS)
public class CardController {

    private final CardService cardService;

    @PostMapping(Path.CREATE)
    public ResponseEntity<CardResponseDto> createCard(@RequestBody @Valid CardRequestDto cardRequestDto) {
        CardResponseDto card = cardService.create(cardRequestDto);
        return ResponseEntity.ok(card);
    }

    @GetMapping(Path.FIND_WITH_OWNER_ID)
    public ResponseEntity<List<CardResponseDto>> findByOwnerId(@PathVariable @Positive Integer ownerId) {
        List<CardResponseDto> byUserId = cardService.findByUserId(ownerId);
        return ResponseEntity.ok(byUserId);
    }

    @DeleteMapping(Path.DELETE_WITH_OWNER_ID)
    public ResponseEntity<Void> deleteAllByOwnerId(@PathVariable @Positive Integer ownerId) {
        cardService.deleteAllByOwnerId(ownerId);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(Path.DELETE_WITH_CARD_ID)
    public ResponseEntity<Void> deleteByCardId(@PathVariable @Positive Integer cardId) {
        cardService.deleteByCardId(cardId);
        return ResponseEntity.ok().build();
    }
}
