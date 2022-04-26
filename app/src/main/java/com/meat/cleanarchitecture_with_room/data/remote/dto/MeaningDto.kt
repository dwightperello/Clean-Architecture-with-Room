package com.meat.cleanarchitecture_with_room.data.remote.dto


import androidx.annotation.Keep
import com.meat.cleanarchitecture_with_room.domain.model.Meaning

@Keep
data class MeaningDto(
    val partOfSpeech: String,
    val definitions: List<DefinitionDto>,
    val synonyms: List<Any>,
    val antonyms: List<Any>
){
    fun toMeaning(): Meaning {
        return Meaning(
        partOfSpeech=partOfSpeech,
        definitions=definitions.map { it.toDefinition() },

        )
    }
}