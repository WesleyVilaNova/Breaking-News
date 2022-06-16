package com.example.newsinformed

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.newsinformed.databinding.FragmentFavoriteBinding

class FavoriteFragment : Fragment(R.layout.fragment_favorite) {

    private lateinit var binding: FragmentFavoriteBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = FragmentFavoriteBinding.bind(view)
    }
}
