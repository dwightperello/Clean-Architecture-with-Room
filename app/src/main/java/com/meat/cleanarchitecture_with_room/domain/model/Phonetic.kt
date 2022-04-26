package com.meat.cleanarchitecture_with_room.domain.model

import com.meat.cleanarchitecture_with_room.data.remote.dto.License

data class Phonetic(
    val text: String,
    val audio: String,
    val sourceUrl: String,
    val license: License
)
