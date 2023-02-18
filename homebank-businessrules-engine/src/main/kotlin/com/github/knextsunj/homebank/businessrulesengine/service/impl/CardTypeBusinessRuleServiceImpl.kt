package com.github.knextsunj.homebank.businessrulesengine.service.impl

import com.github.knextsunj.homebank.businessrulesengine.dao.CardTypeBusinessRuleDAO
import com.github.knextsunj.homebank.businessrulesengine.exception.DataNotFoundException
import com.github.knextsunj.homebank.businessrulesengine.exception.RequiredInputDataMissingException
import com.github.knextsunj.homebank.businessrulesengine.service.CardTypeBusinessRuleService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
open class CardTypeBusinessRuleServiceImpl : CardTypeBusinessRuleService {

    @Autowired
    open lateinit var cardTypeBusinessRuleDAO: CardTypeBusinessRuleDAO

    override fun deDupCardType(name: String?): Boolean {

        if (name == null) {
            throw RequiredInputDataMissingException("Required attribute for validation color card name is not given")
        }

        var status: Boolean = false
        var sqlQuery: String = "select count(1) from homebank1.card_type where name=?"

        /**
         * Kotlin elvis operator - If count is null then throw business exception else
         * collect the count
         * Kotlin named parameters used here for the function invocation - note that order of the params in the function definition is
         * reverse of what is provided here.Result of invocation collected into an Int- kotlin primitive type
         */
        val count: Int = cardTypeBusinessRuleDAO.fetchCardTypeByName(name = name, query = sqlQuery)
        // Usage of kotlin string template in the exception message
            ?: throw DataNotFoundException("No data fetched for name:$name")

        if (count == 0) {
            status = true
        }
        return status
    }


}