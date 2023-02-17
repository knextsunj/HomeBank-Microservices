package com.github.knextsunj.homebank.businessrulesengine.controller;

import com.github.knextsunj.homebank.businessrulesengine.service.ColorCardBusinessRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/colorcardbusinessrule")
public class ColorCardBusinessRuleController {

    @Autowired
    private ColorCardBusinessRuleService colorCardBusinessRuleService;

    @PostMapping(value = "/dedup/{name}")
    public boolean deDupColorCard(@PathVariable("name") String name) {
        return colorCardBusinessRuleService.deDupColorCard(name);
    }


}
