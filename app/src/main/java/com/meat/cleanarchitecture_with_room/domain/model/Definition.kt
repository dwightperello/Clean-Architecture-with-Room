package com.meat.cleanarchitecture_with_room.domain.model

data class Definition(
    val definition: String,
    val synonyms: List<String>,
    val antonyms: List<String>,
    val examples:String?
)
