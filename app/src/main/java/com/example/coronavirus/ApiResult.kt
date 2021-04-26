package com.example.coronavirus

import com.example.coronavirus.utils.logE
import retrofit2.Response

sealed class ApiResult<out T: Any> {
    data class Success<out T : Any>(val data: T) : ApiResult<T>()
    data class Error(val exception: String) : ApiResult<Nothing>()
}

suspend fun <T : Any> safeApiCall(call: suspend () -> Response<T>): ApiResult<T> {
    // TODO : showProgressDialog()
    return try {
        val myResp = call.invoke()
        when {
            myResp.isSuccessful -> ApiResult.Success(myResp.body()!!)
            else -> {
                logE(myResp.errorBody()?.toString() ?: "Something goes wrong")
                ApiResult.Error(myResp.errorBody()?.toString() ?: "Something goes wrong")
            }
        }
    } catch (e: Exception) {
        logE(e.message ?: "Internet error runs")
        ApiResult.Error(e.message ?: "Internet error runs")
    }
    finally {
        // TODO : hideProgressDialog()
    }
}