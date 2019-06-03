package com.raul.partidosdex

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.raul.partidosdex.Adapter.PartidosAdapter
import com.raul.partidosdex.Entities.Partido
import com.raul.partidosdex.ViewModel.PartidoViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var partidoViewModel: PartidoViewModel
    private lateinit var partidosAdapter: PartidosAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        partidosAdapter = PartidosAdapter(this,{partido:Partido -> triggerActivity(partido)})
        val recyclerView=findViewById<RecyclerView>(R.id.list_partidos)
        recyclerView.layoutManager=LinearLayoutManager(this)

        partidoViewModel=ViewModelProviders.of(this).get(PartidoViewModel::class.java)

        partidoViewModel.allPartido.observe(this,androidx.lifecycle.Observer{partidos->

            partidos?.let { partidosAdapter.setPartido(it) }

        })

        btn_new.setOnClickListener {
            var intent= Intent(this, NuevoPartidoActivity::class.java)
            startActivity(intent)
        }



    }


    private fun triggerActivity(partido: Partido) {
/*

*/
    }

}
