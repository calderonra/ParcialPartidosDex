package com.raul.partidosdex.Entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "partido_table")
data class Partido(@PrimaryKey(autoGenerate = true)@ColumnInfo(name = "id")val id: Int,
                   @ColumnInfo(name = "fecha")val fecha:String,
                   @ColumnInfo(name = "equipo1Name" )val equipo1Name:String,
                   @ColumnInfo(name = "equipo1Score")  val equipo1Score:Int,
                   @ColumnInfo(name = "equipo2Name" )val equipo2Name:String,
                   @ColumnInfo(name = "equipo2Score")  val equipo2Score:Int)