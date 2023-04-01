package com.steve_md.socialsapp.screens.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.steve_md.socialsapp.data.api.SocialsApiService
import com.steve_md.socialsapp.model.Posts
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(
    private val socialsApiService: SocialsApiService
) : ViewModel() {

    private var postsResponse : List<Posts> by mutableStateOf(listOf())

    var errorMessage : String by mutableStateOf("")

    fun getAllPosts() {
            viewModelScope.launch {
                try {
                    val postsLists = socialsApiService.getAllPosts()
                    postsResponse = postsLists
                } catch (e:Exception){
                    errorMessage = e.message.toString()
                }
            }
    }
}