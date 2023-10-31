package com.exampssle.loginmicroservice

import java.io.Serializable

data class Category(val name: String, val courses: List<Course>, val imageResourceId: Int, var checked: Boolean = false):
    Serializable


data class Course(val name: String, val duration: String , val instructor : String,val description : String , val location: String):Serializable