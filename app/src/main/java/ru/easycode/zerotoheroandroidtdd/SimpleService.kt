package ru.easycode.zerotoheroandroidtdd

import retrofit2.http.GET
import retrofit2.http.Path
import com.google.gson.annotations.SerializedName

interface SimpleService {
    @GET("{fullUrl}")
    suspend fun fetch(@Path(value = "fullUrl", encoded = true) url: String): SimpleResponse
}

data class SimpleResponse(
    @SerializedName("text")
    val text: String
)