package com.derrick.motion.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.derrick.motion.adapters.MovieAdapter
import com.derrick.motion.data.models.Movie
import com.derrick.motion.databinding.FragmentHomeBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class HomeFragment : Fragment() {

    val moviesList = listOf("Blacklist", "HomeLand", "Chuck")

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val view: View = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = MovieAdapter()
        binding.movieList.adapter = adapter

        val data = mutableListOf<Movie>()
        for (title in moviesList) {
            val movie = Movie(title)
            data.add(movie)
        }
        adapter.data = data
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}