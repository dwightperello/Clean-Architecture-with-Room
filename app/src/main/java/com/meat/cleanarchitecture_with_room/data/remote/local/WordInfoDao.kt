package com.meat.cleanarchitecture_with_room.data.remote.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.meat.cleanarchitecture_with_room.data.remote.local.entity.WordInfoEntity

@Dao
interface WordInfoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWordInfos(infos:List<WordInfoEntity>)

    @Query("DELETE FROM wordinfoentity WHERE word IN(:words)")
    suspend fun deleteWordInfos(words:List<String>)

    @Query("SELECT * FROM wordinfoentity where word LIKE '%' || :word || '%'")
    suspend fun getWordInfos(word: String):List<WordInfoEntity>
}