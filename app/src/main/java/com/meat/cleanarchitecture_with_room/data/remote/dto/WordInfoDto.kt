package com.meat.cleanarchitecture_with_room.data.remote.dto


import androidx.annotation.Keep
import com.meat.cleanarchitecture_with_room.data.remote.local.entity.WordInfoEntity
import com.meat.cleanarchitecture_with_room.domain.model.WordInfo

@Keep
data class WordInfoDto(
    val word: String,
    val phonetic: String,
    val phonetics: List<PhoneticDto>,
    val meanings: List<MeaningDto>,
    val license: LicenseX,
    val sourceUrls: List<String>
){
    fun toWordInfoEntity():WordInfoEntity{
        return  WordInfoEntity(
            word=word,
            phonetic=phonetic,
            meanings=meanings.map { it.toMeaning() }

        )
    }
}