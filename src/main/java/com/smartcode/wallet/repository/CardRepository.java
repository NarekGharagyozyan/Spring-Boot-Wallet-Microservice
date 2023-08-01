package com.smartcode.wallet.repository;

import com.smartcode.wallet.model.entity.CardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardRepository extends JpaRepository<CardEntity, Integer> {
    List<CardEntity> findAllByOwnerId(Integer userId);

    void deleteAllByOwnerId(Integer userId);
}