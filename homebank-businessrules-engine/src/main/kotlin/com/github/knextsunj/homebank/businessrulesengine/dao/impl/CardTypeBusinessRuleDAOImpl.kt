package com.github.knextsunj.homebank.businessrulesengine.dao.impl

import com.github.knextsunj.homebank.businessrulesengine.dao.CardTypeBusinessRuleDAO
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Repository

@Repository
open class CardTypeBusinessRuleDAOImpl : CardTypeBusinessRuleDAO {

    @Autowired
    open lateinit var jdbcTemplate: JdbcTemplate

    override fun fetchCardTypeByName(query: String?, name: String?): Int? {
        val clazz: Class<Int> = Int::class.java
        return jdbcTemplate.queryForObject(query, clazz, name);
    }


}