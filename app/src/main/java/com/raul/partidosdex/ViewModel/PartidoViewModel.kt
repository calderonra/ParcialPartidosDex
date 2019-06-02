package com.raul.partidosdex.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.raul.partidosdex.DAO.PartidosRoomDatabase
import com.raul.partidosdex.Entities.Partido
import com.raul.partidosdex.Repository.PartidosRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PartidoViewModel (application: Application): AndroidViewModel(application){
    private val repository : PartidosRepository
    val allPartido:LiveData<List<Partido>>

    init {
        val partidoDao=PartidosRoomDatabase.getDatabase(application).partidosDao()
        repository= PartidosRepository(partidoDao)
        allPartido=repository.allPartidos
    }
    fun insert (partido: Partido)=viewModelScope.launch(Dispatchers.IO) {
        repository.insert(partido)
    }

}