package br.com.first.network

import br.com.first.data.model.Response
import retrofit2.HttpException

open class ResponseHandler {

    fun <T : Any> handleException(e: Exception): Response<Throwable> {
        return when (e) {
            is HttpException -> Response.Error(getErrorMessage(e))
            else -> Response.Error(e)
        }
    }

    private fun getErrorMessage(e: HttpException): Exception {
        return when (e.code()) {
            401 -> HandleHttpException.Unautorized()
            404 -> HandleHttpException.NotFound()
            else ->  Exception(e.message())
        }
    }
}

sealed class HandleHttpException : Exception() {
    class Unautorized : HandleHttpException()
    class NotFound : HandleHttpException()
}