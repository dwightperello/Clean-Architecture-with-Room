package com.meat.cleanarchitecture_with_room.data.remote.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.meat.cleanarchitecture_with_room.data.remote.dto.LicenseX
import com.meat.cleanarchitecture_with_room.data.remote.dto.MeaningDto
import com.meat.cleanarchitecture_with_room.data.remote.dto.PhoneticDto
import com.meat.cleanarchitecture_with_room.domain.model.Meaning
import com.meat.cleanarchitecture_with_room.domain.model.WordInfo

@Entity
data class WordInfoEntity(
    val word: String,
    val phonetic: String,
    val meanings: List<Meaning>,
    val sourceUrls: List<String>,
    @PrimaryKey val id: Int? = null
){
    fun toWordInfo():WordInfo{
        return  WordInfo(
        word=word,
        phonetic=phonetic,
        meanings=meanings,


        )
    }
}
