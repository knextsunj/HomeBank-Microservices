package com.github.knextsunj.homebank.businessrulesengine.dao

interface CardTypeBusinessRuleDAO {

    fun fetchCardTypeByName(query: String?, name: String?): Int?
}