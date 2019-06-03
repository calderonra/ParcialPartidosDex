package com.raul.partidosdex

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.raul.partidosdex.ViewModel.PartidoViewModel
import kotlinx.android.synthetic.main.new_partido.*

class PartidoActivity:AppCompatActivity() {


    private var score1=0
    private var score2=0

    private lateinit var partidoViewModel: PartidoViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.new_partido)

        team_a_one_score.setOnClickListener {

            var n_entrada:Int
            var str_entrada:String

            n_entrada=Integer.parseInt(team_a_score.getText().toString())
            n_entrada+=1
            str_entrada=Integer.toBinaryString(n_entrada)
            team_a_one_score.setText(str_entrada)

        }

        team_a_two_score.setOnClickListener {

            var n_entrada:Int
            var str_entrada:String

            n_entrada=Integer.parseInt(team_a_score.getText().toString())
            n_entrada+=2
            str_entrada=Integer.toBinaryString(n_entrada)
            team_a_one_score.setText(str_entrada)
        }

        team_a_three_score.setOnClickListener {

            var n_entrada:Int
            var str_entrada:String

            n_entrada=Integer.parseInt(team_a_score.getText().toString())
            n_entrada+=3
            str_entrada=Integer.toBinaryString(n_entrada)
            team_a_one_score.setText(str_entrada)
        }

        team_b_one_score.setOnClickListener {

            var n_entrada:Int
            var str_entrada:String

            n_entrada=Integer.parseInt(team_b_score.getText().toString())
            n_entrada+=1
            str_entrada=Integer.toBinaryString(n_entrada)
            team_b_one_score.setText(str_entrada)
        }

        team_b_two_score.setOnClickListener {

            var n_entrada:Int
            var str_entrada:String

            n_entrada=Integer.parseInt(team_b_score.getText().toString())
            n_entrada+=2
            str_entrada=Integer.toBinaryString(n_entrada)
            team_b_one_score.setText(str_entrada)
        }

        team_b_three_score.setOnClickListener {

            var n_entrada:Int
            var str_entrada:String

            n_entrada=Integer.parseInt(team_b_score.getText().toString())
            n_entrada+=3
            str_entrada=Integer.toBinaryString(n_entrada)
            team_b_one_score.setText(str_entrada)
        }

        partidoViewModel


    }


}