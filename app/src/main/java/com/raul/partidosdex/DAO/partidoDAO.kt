package com.raul.partidosdex.DAO


import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.raul.partidosdex.Entities.Partido


@Dao
interface partidoDao{
    @Query("SELECT * from partido_table order by id ASC")
    fun getAllPartidos():LiveData<List<Partido>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(partido: Partido)

    @Query("DELETE FROM PARTIDO_TABLE")
    fun deleteAll()
}