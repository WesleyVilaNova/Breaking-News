package com.example.newsinformed.view.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.newsinformed.R
import com.example.newsinformed.databinding.FragmentTrendingBinding

class FavoriteFragment : Fragment(R.layout.fragment_trending) {

    private lateinit var binding: FragmentTrendingBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = FragmentTrendingBinding.bind(view)
    }
}
