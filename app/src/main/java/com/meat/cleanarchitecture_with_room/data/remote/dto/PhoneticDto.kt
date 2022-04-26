package com.meat.cleanarchitecture_with_room.data.remote.dto


import androidx.annotation.Keep
import com.meat.cleanarchitecture_with_room.domain.model.Phonetic

@Keep
data class PhoneticDto(
    val text: String,
    val audio: String,
    val sourceUrl: String,
    val license: License
){
    fun toPhonetic(): Phonetic {
        return Phonetic(
            text=text,
            audio=audio,
            sourceUrl=sourceUrl,
            license=license
        )
    }
}