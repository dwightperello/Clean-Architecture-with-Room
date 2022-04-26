package com.meat.cleanarchitecture_with_room.data.repository

import com.meat.cleanarchitecture_with_room.core.util.Resource
import com.meat.cleanarchitecture_with_room.data.remote.api.ApiService
import com.meat.cleanarchitecture_with_room.data.remote.local.WordInfoDao
import com.meat.cleanarchitecture_with_room.domain.model.WordInfo
import com.meat.cleanarchitecture_with_room.domain.repository.WordInfoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class WordInfoRepositoryImpl( private val api :ApiService, private val dao: WordInfoDao):WordInfoRepository {

    override fun getWordInfo(word: String): Flow<Resource<List<WordInfo>>> = flow {
      emit(Resource.Loading())
        val wordInfos = dao.getWordInfos(word).map { it.toWordInfo() }
        emit(Resource.Loading(data= wordInfos))

        try {
            val remoteinfos = api.getWordMeaning(word)
            dao.deleteWordInfos(remoteinfos.map { it.word })
            dao.insertWordInfos(remoteinfos.map { it.toWordInfoEntity() })
        }catch (e:HttpException){
            emit(Resource.Error("SOmething went wrong", data = wordInfos))
        }catch (e:IOException){
            emit(Resource.Error("Cant react server", data = wordInfos))
        }

        val newWordInfos = dao.getWordInfos(word).map { it.toWordInfo() }
        emit(Resource.Success(newWordInfos))
    }
}