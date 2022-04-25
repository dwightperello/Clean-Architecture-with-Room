package com.meat.cleanarchitecture_with_room.data.remote.dto


import androidx.annotation.Keep
import com.meat.cleanarchitecture_with_room.domain.model.Definition

@Keep
data class DefinitionDto(
    val definition: String,
    val synonyms: List<String>,
    val antonyms: List<String>,
    val examples:String?
){
    fun toDefinition():Definition{
        return Definition(
            definition = definition,
            synonyms=synonyms,
            antonyms = antonyms,
            examples=examples
        )
    }
}