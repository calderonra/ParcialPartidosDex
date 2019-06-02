package com.raul.partidosdex.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.raul.partidosdex.DAO.partidoDao
import com.raul.partidosdex.Entities.Partido
import com.raul.partidosdex.R
import kotlinx.android.synthetic.main.cardview_partido.view.*


class PartidosAdapter internal  constructor(context: Context, val clickListenerBoton: (Partido) -> Unit, val clickListenerViewHolder: (Partido)->Unit ) : RecyclerView.Adapter<PartidosAdapter.ViewHolder>() {
    private var partidos: List<Partido> = emptyList()
    private val inflater: LayoutInflater = LayoutInflater.from(context)
    public var switch = true

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.cardview_partido, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = partidos.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(partidos[position], clickListenerBoton,clickListenerViewHolder )

    internal fun setPartido(partidos: List<Partido>) {
        this.partidos = partidos
        notifyDataSetChanged()
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(book: Partido, clickListenerBoton: (Partido) -> Unit, clickListenerViewHolder:(Partido) -> Unit) = with(itemView) {

            Tv_book_name.text = book.fecha

            this.setOnClickListener{
                clickListenerBoton(book)
            }
        }
    }
}