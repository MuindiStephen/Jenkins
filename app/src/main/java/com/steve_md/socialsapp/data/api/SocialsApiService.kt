package com.steve_md.socialsapp.data.api

import com.steve_md.socialsapp.model.Posts
import retrofit2.http.GET

interface SocialsApiService {
    @GET("/photos")
    suspend fun getAllPosts() : List<Posts>
}