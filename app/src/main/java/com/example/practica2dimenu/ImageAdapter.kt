package com.example.practica2dimenu

import android.app.Activity
import android.content.Context
import android.view.ContextMenu
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.practica2dimenu.R

class ImageAdapter(
    private val card: List<CardItem>,
    private val images: List<Int>,
    private val context: Context
) : RecyclerView.Adapter<ImageAdapter.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view), View.OnCreateContextMenuListener {
        val imageView: ImageView = view.findViewById(R.id.imageView)
        val title: TextView = itemView.findViewById(R.id.card)
        init {
            view.setOnCreateContextMenuListener(this)
        }

        override fun onCreateContextMenu(menu: ContextMenu, v: View, menuInfo: ContextMenu.ContextMenuInfo?) {
            menu.add(adapterPosition, R.id.edit, 0, "Editar")
            menu.add(adapterPosition, R.id.delete, 1, "Eliminar")
            menu.add(adapterPosition, R.id.share, 2, "Compartir")
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_view, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val cardItem = card[position]
        holder.title.text = cardItem.title
        holder.imageView.setImageResource(images[position])
    }

    override fun getItemCount(): Int = images.size
}
