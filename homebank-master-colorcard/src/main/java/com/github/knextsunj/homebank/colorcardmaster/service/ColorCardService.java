package com.github.knextsunj.homebank.colorcardmaster.service;

import com.github.knextsunj.homebank.colorcardmaster.dto.ColorCardDTO;

import java.util.List;

public interface ColorCardService {


    boolean saveColorCard(ColorCardDTO colorCardDTO);

    boolean updateColorCard(ColorCardDTO colorCardDTO);

    ColorCardDTO fetchColorCardById(long id);

    List<ColorCardDTO> fetchAllColorCard();
}
