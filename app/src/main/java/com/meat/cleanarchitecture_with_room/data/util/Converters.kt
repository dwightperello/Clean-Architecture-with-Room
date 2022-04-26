package com.meat.cleanarchitecture_with_room.data.util

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.google.gson.reflect.TypeToken
import com.meat.cleanarchitecture_with_room.domain.model.Meaning

@ProvidedTypeConverter
class Converters(private val jsonParser: JsonParser) {

    @TypeConverter
    fun fromMeaningJson(json:String):List<Meaning>{
        return jsonParser.fromJson<ArrayList<Meaning>>(
            json,
            object :TypeToken<ArrayList<Meaning>>(){}.type
        )?: emptyList()
    }

    @TypeConverter
    fun toMeaningJson(meaning: Meaning):String{
        return jsonParser.toJson(
            meaning,
            object :TypeToken<ArrayList<Meaning>>(){}.type
        )?:""
    }
}