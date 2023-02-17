package com.github.knextsunj.homebank.businessrulesengine.service.impl

import com.github.knextsunj.homebank.businessrulesengine.dao.ColorCardBusinessRuleDAO
import com.github.knextsunj.homebank.businessrulesengine.exception.DataNotFoundException
import com.github.knextsunj.homebank.businessrulesengine.exception.RequiredInputDataMissingException
import com.github.knextsunj.homebank.businessrulesengine.service.ColorCardBusinessRuleService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
open class ColorCardBusinessRuleServiceImpl : ColorCardBusinessRuleService {

    /**
     * lateinit allows initialization of a not null property
     * outside constructor
     */
    @Autowired
    open lateinit var colorCardBusinessRuleDAO: ColorCardBusinessRuleDAO


    override fun deDupColorCard(name: String?): Boolean {

        if (name == null) {
            throw RequiredInputDataMissingException("Required attribute for validation color card name is not given")
        }

        var status: Boolean = false
        var sqlQuery: String = "select count(1) from homebank1.color_card where name=?"

        /**
         * Kotlin elvis operator - If count is null then throw business exception else
         * collect the count
         * Kotlin named parameters used here for the function invocation - note that order of the params in the function definition is
         * reverse of what is provided here.Result of invocation collected into an Int- kotlin primitive type
         */
        val count: Int = colorCardBusinessRuleDAO.fetchColorCardByName(name = name, query = sqlQuery)
        // Usage of kotlin string template in the exception message
            ?: throw DataNotFoundException("No data fetched for name:$name")

        if (count == 0) {
            status = true
        }
        return status
    }
}