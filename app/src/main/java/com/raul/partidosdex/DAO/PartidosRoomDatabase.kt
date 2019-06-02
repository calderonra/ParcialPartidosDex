package com.raul.partidosdex.DAO

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.raul.partidosdex.Entities.Partido


@Database(entities=[Partido::class],version=1)
public abstract class PartidosRoomDatabase : RoomDatabase(){
    abstract fun partidosDao(): partidoDao
    companion object {
        @Volatile
        private var INSTANCE: PartidosRoomDatabase? = null

        fun getDatabase(context: Context): PartidosRoomDatabase {
            return INSTANCE ?: synchronized(this) {
                // Create database here
                val instance = // TODO
                    Room.databaseBuilder(
                        context.applicationContext,
                        PartidosRoomDatabase::class.java,
                        "Partidos_database"
                    ).build()
                    INSTANCE = instance
                instance
            }
        }
    }
}

