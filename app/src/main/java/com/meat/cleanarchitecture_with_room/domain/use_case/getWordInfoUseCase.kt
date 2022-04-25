package com.meat.cleanarchitecture_with_room.domain.use_case

import com.meat.cleanarchitecture_with_room.core.util.Resource
import com.meat.cleanarchitecture_with_room.domain.model.WordInfo
import com.meat.cleanarchitecture_with_room.domain.repository.WordInfoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class getWordInfoUseCase (private val repository: WordInfoRepository) {

    operator fun invoke(word:String):Flow<Resource<List<WordInfo>>>{
        if(word.isBlank()){
            return flow {  }
        }
        return repository.getWordInfo(word)
    }
}