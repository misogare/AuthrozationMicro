package com.example.loginmicroservice

import com.exampssle.loginmicroservice.Category
import com.exampssle.loginmicroservice.Course
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface LoginApi {

    @GET("auth/login")
    suspend fun login(@Query("username") username: String, @Query("password") password: String): LoginResponse
    @GET("api/category")
    suspend  fun getCategories(): List<Category>
    @GET("api/courses")
    fun getCourses(): Call<List<Course>>
    @GET("auth/forgotpassword")
    suspend fun forgotpassword (@Query("username") username: String): LoginResponse
    @GET("auth/resetpassword")
    suspend fun resetPassword (@Query("username") username: String,@Query("password") password: String,@Query("confirmPassword") confirmPassword: String):LoginResponse
// you can do it with Response too enqueue has response with version 2.5 retrofit 
}