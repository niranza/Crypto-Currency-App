package com.niran.cryptocurrency.common

sealed class Resource<T>(data: T?, message: String?) {
    class Loading<T>(val data: T? = null) : Resource<T>(data, null)
    class Success<T>(val data: T) : Resource<T>(data, null)
    class Error<T>(val message: String, val data: T? = null) : Resource<T>(data, message)
}