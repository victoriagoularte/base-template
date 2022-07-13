package br.com.first.data.model

sealed class Result<out T> {
    data class Success<out R>(val value: R) : Result<R>()
    data class Error<>()
}
