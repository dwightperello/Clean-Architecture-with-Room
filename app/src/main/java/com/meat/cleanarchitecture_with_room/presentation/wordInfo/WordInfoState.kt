package com.meat.cleanarchitecture_with_room.presentation.wordInfo

import com.meat.cleanarchitecture_with_room.domain.model.WordInfo

data class WordInfoState(
    val wordInfoItems: List<WordInfo> = emptyList(),
    val isLoading:Boolean = false
)


