package com.raul.partidosdex.Repository

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.raul.partidosdex.DAO.partidoDao
import com.raul.partidosdex.Entities.Partido

class PartidosRepository (private val partidosDao: partidoDao){

    val allPartidos: LiveData<List<Partido>> = partidosDao.getAllPartidos()

    @WorkerThread
    suspend fun insert(partido: Partido){
        partidosDao.insert(partido)
    }


}