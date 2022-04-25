package com.meat.cleanarchitecture_with_room.data.remote.api

import com.meat.cleanarchitecture_with_room.data.remote.dto.WordInfoDto
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {


    @GET("/api/v2/entries/en/{word}")
    suspend fun getWordMeaning(@Path("word")word:String) : List<WordInfoDto>
}