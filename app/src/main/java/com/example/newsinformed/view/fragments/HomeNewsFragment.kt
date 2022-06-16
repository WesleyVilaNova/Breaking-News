package com.example.newsinformed.view.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.newsinformed.R
import com.example.newsinformed.databinding.FragmentHomeListNewsBinding

class HomeNewsFragment : Fragment(R.layout.fragment_home_list_news) {

    private lateinit var binding: FragmentHomeListNewsBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = FragmentHomeListNewsBinding.bind(view)
    }
}
