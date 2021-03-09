package com.dansiapa.ranggainternship.repository

import com.dansiapa.ranggainternship.model.LoginResponseModel
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface InterfaceAPI {

    @GET("user/login")
    fun login(@Query("email") email: String, @Query("password") password: String): Single<LoginResponseModel>
}