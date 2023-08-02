package com.smartcode.wallet.model.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@MappedSuperclass
@Setter
@Getter
public class BaseDto {

    @NotBlank
    private String cardName;

    @NotBlank
    private String ownerName;

    @NotBlank
    private String number;

    @NotBlank
    private String expDate;

    @NotNull
    private Integer ownerId;

}
