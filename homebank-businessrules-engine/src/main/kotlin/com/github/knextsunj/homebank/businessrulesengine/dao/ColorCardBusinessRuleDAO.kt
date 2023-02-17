package com.github.knextsunj.homebank.businessrulesengine.dao

interface ColorCardBusinessRuleDAO {
    fun fetchColorCardByName(query: String?, name: String?): Int?
}