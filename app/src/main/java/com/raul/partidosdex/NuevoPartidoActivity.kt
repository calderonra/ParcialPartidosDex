package com.raul.partidosdex

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import android.widget.Toast
import com.raul.partidosdex.Entities.Partido
import com.raul.partidosdex.ViewModel.PartidoViewModel
import kotlinx.android.synthetic.main.team_names.*


class NuevoPartidoActivity : AppCompatActivity(){
    var cont = 0

    private lateinit var partidoViewModel: PartidoViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.team_names)

        partidoViewModel= ViewModelProviders.of(this).get(PartidoViewModel::class.java)

        btnInsertarNombres.setOnClickListener{
            try {
                if (!ed_equipo1.text.isEmpty() && !ed_equipo2.text.isEmpty()){
                    cont+=1
                    var insertPartido = Partido(cont,"27/02/19",ed_equipo1.text.toString(),0,ed_equipo2.text.toString(),0)
                    partidoViewModel.insert(insertPartido)

                     var intent = Intent(this, PartidoActivity::class.java)
                    startActivity(intent)



                    Toast.makeText(this@NuevoPartidoActivity, "Ingresado con exito!!!!", Toast.LENGTH_LONG)

                }
            }catch (e : Exception){
                Toast.makeText(this@NuevoPartidoActivity, "Hubo un error al ingresar el dato!!", Toast.LENGTH_LONG)

            }
        }

    }



}