package com.example.albums.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.net.toUri
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.albums.R
import com.example.app.cache.albums.Album

class AlbumsRVAdapter(val albums: List<Album>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_album, parent, false)
        return ItemViewHolder(view)
    }

    override fun getItemCount(): Int {
        return albums.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ItemViewHolder).userIdTextView.text = albums[position].userId.toString()
        holder.titleTextView.text = albums[position].title

        holder.rootLayout.setOnClickListener {
            val moviesURI = "photos://photo".toUri()
            Navigation.findNavController(holder.rootLayout).navigate(moviesURI)
        }
    }

    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val titleTextView: TextView = itemView.findViewById(R.id.titleTextView)
        val userIdTextView: TextView = itemView.findViewById(R.id.userIdTextView)
        val rootLayout: ConstraintLayout = itemView.findViewById(R.id.albumRootLayout)
    }
}