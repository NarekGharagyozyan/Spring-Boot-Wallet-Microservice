package com.smartcode.wallet.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Entity
@Table(name = "cards")
public class CardEntity extends BaseEntity{

    @Column(nullable = false)
    private String cardName;

    @Column(nullable = false)
    private String ownerName;

    @Column(nullable = false, unique = true)
    private String number;

    @Column(nullable = false)
    private String expDate;

    @Column(nullable = false)
    private Integer ownerId;

}
