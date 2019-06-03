package com.raul.partidosdex.DAO

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.raul.partidosdex.Entities.Partido
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


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

        private class PartidosDatabaseCallback(
            private val scope: CoroutineScope
        ) : RoomDatabase.Callback(){
            override fun onOpen(db: SupportSQLiteDatabase) {
                super.onOpen(db)

                INSTANCE?.let{database->

                    scope.launch (Dispatchers.IO){
                        populateDatabse(database.partidosDao())
                    }

                }

            }
        }

        suspend fun populateDatabse(partidoDao:partidoDao){

            partidoDao.deleteAll()
            var partido= Partido(0,"21/02/13","PSG",2,"Ajax",1)
        }

    }
}

