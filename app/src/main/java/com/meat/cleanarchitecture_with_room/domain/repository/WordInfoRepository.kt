package com.meat.cleanarchitecture_with_room.domain.repository

import com.meat.cleanarchitecture_with_room.core.util.Resource
import com.meat.cleanarchitecture_with_room.domain.model.WordInfo
import kotlinx.coroutines.flow.Flow

interface WordInfoRepository {

    fun getWordInfo(word:String) :Flow<Resource<List<WordInfo>>>
}