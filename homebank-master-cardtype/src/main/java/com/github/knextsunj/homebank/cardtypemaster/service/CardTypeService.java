package com.github.knextsunj.homebank.cardtypemaster.service;

import com.github.knextsunj.homebank.cardtypemaster.dto.CardTypeDTO;

import java.util.List;

public interface CardTypeService {


    boolean saveCardType(CardTypeDTO cardTypeDTO);

    boolean updateCardType(CardTypeDTO cardTypeDTO);

    CardTypeDTO fetchCardTypeById(long id);

    List<CardTypeDTO> fetchAllCardType();
}
