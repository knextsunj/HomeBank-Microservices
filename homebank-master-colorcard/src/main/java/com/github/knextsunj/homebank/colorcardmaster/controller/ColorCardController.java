package com.github.knextsunj.homebank.colorcardmaster.controller;

import com.github.knextsunj.homebank.colorcardmaster.dto.ColorCardDTO;
import com.github.knextsunj.homebank.colorcardmaster.service.ColorCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/colorcard")
public class ColorCardController {

    @Autowired
    private ColorCardService colorCardService;

    @GetMapping(value = "/findAll")
    public List<ColorCardDTO> findAllColorCard() {
        return colorCardService.fetchAllColorCard();
    }

    @PostMapping(value = "/save")
    public boolean saveColorCard(@RequestBody ColorCardDTO colorCardDTO) {
        return colorCardService.saveColorCard(colorCardDTO);
    }

    @PutMapping(value = "/update")
    public boolean updateColorCard(@RequestBody ColorCardDTO colorCardDTO) {
        return colorCardService.updateColorCard(colorCardDTO);
    }
}




