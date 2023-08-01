package com.smartcode.wallet.util.constants;

public interface Path {
    String CARDS = "/cards";
    String CREATE = "/create";
    String FIND_WITH_OWNER_ID = "/find/{ownerId}";
    String DELETE_WITH_OWNER_ID = "/delete/owner/{ownerId}";
    String DELETE_WITH_CARD_ID = "/delete/{cardId}";

}
