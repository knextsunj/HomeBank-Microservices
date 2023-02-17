package com.github.knextsunj.homebank.businessrulesengine.exception

open class RequiredInputDataMissingException : RuntimeException {
    constructor(message: String?, throwable: Throwable?) : super(message, throwable)
    constructor(message: String?) : super(message)
}