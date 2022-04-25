package com.meat.cleanarchitecture_with_room.domain.model

import com.meat.cleanarchitecture_with_room.data.remote.dto.DefinitionDto

data class Meaning(
    val partOfSpeech: String,
    val definitions: List<Definition>,

)
