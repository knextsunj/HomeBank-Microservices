package com.github.knextsunj.homebank.businessrulesengine.controller;

import com.github.knextsunj.homebank.businessrulesengine.service.CardTypeBusinessRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cardtypebusinessrule")
public class CardTypeBusinessRuleController {

    @Autowired
    private CardTypeBusinessRuleService cardTypeBusinessRuleService;

    @PostMapping(value = "/dedup/{name}")
    public boolean deDupCardType(@PathVariable("name") String name) {
        return cardTypeBusinessRuleService.deDupCardType(name);
    }


}
