package com.github.knextsunj.homebank.cardtypemaster.controller;

import com.github.knextsunj.homebank.cardtypemaster.dto.CardTypeDTO;
import com.github.knextsunj.homebank.cardtypemaster.service.CardTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/cardtype")
public class CardTypeController {

    @Autowired
    private CardTypeService colorCardService;

    @GetMapping(value = "/findAll")
    public List<CardTypeDTO> findAllColorCard() {
        return colorCardService.fetchAllCardType();
    }

    @PostMapping(value = "/save")
    public boolean saveColorCard(@RequestBody CardTypeDTO cardTypeDTO) {
        return colorCardService.saveCardType(cardTypeDTO);
    }

    @PutMapping(value = "/update")
    public boolean updateColorCard(@RequestBody CardTypeDTO cardTypeDTO) {
        return colorCardService.updateCardType(cardTypeDTO);
    }
}




