package com.github.knextsunj.homebank.businessrulesengine.exception

open class DataNotFoundException : RuntimeException {

    constructor(message: String?, throwable: Throwable?) : super(message, throwable)
    constructor(message: String?) : super(message)
}