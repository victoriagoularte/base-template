package br.com.first.data.model

sealed class Response<out T> {
    data class Success<out R>(val value: R) : Response<R>()
    data class Error(val throwable: Throwable) : Response<Throwable>()
}
