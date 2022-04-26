package com.meat.cleanarchitecture_with_room.domain.model

import com.meat.cleanarchitecture_with_room.data.remote.dto.LicenseX
import com.meat.cleanarchitecture_with_room.data.remote.dto.MeaningDto
import com.meat.cleanarchitecture_with_room.data.remote.dto.PhoneticDto

data class WordInfo(
    val word: String,
    val phonetic: String,
    val meanings: List<Meaning>


)
