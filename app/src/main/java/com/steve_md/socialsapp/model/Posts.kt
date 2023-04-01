package com.steve_md.socialsapp.model

/**
 * This [Posts] model class or data class holds the response data
 */
data class Posts(
    val userId:Int,
    val id:Int,
    val title:String,
    val body :String
)
