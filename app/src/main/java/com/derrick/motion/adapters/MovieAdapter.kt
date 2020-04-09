package com.derrick.motion.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.derrick.motion.R
import com.derrick.motion.data.models.Movie


class MovieAdapter : RecyclerView.Adapter<MovieAdapter.ViewHolder>() {
     var data = listOf<Movie>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val movie_title: TextView = itemView.findViewById(R.id.movie_title)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.movie_grid, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = data.size


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movie = data[position]
        holder.movie_title.text = movie.title
    }
}