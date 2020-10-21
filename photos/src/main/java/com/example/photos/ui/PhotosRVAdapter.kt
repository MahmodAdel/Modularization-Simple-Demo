package com.example.photos.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.app.cache.photos.Photo
import com.example.photos.R
import com.squareup.picasso.Picasso

class PhotosRVAdapter(val photos: List<Photo>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_photo, parent, false)
        return ItemViewHolder(itemView = view)
    }

    override fun getItemCount(): Int {
        return photos.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ItemViewHolder).photoTextView.text = photos[position].albumId.toString()
        holder.photoTitleTextView.text = photos[position].title
        Picasso.get()
            .load(photos[position].url)
            .into(holder.photoImageView)

    }

    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val photoTextView: TextView = itemView.findViewById(R.id.albumIdTextView)
        val photoTitleTextView: TextView = itemView.findViewById(R.id.albumTitleTextView)
        val photoImageView: ImageView = itemView.findViewById(R.id.iv_photo)
    }

}