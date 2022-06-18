package com.example.newsinformed.view.fragments

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.newsinformed.R
import com.example.newsinformed.databinding.FragmentHomeListNewsBinding
import com.example.newsinformed.model.ModelNews
import com.example.newsinformed.view.viewmodel.HomeNewsViewModel

class HomeNewsFragment : Fragment(R.layout.fragment_home_list_news) {

    companion object {
        const val TAG: String = ""
    }

    private lateinit var binding: FragmentHomeListNewsBinding
    private val viewModel: HomeNewsViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = FragmentHomeListNewsBinding.bind(view)

        setupObservers()
        loadNewsInit()
        setupEditTextHome()
    }

    private fun setupObservers() {
        viewModel.newsResult.observe(viewLifecycleOwner) { resultNewsOfRequest ->
            setupAdapter(resultNewsOfRequest)
        }
        viewModel.errorMsg.observe(viewLifecycleOwner) {
        }
    }

    private fun loadNewsInit() {
        callingRequestApi("Brazil")
    }

    private fun setupEditTextHome() {
        binding.editTextHome.setOnClickListener {
            val searchText = binding.editTextHome.text.toString()
            if (searchText.isNotEmpty()) {
                callingRequestApi(searchText)
                binding.editTextHome.text.clear()
            } else {
                binding.editTextHome.error = "aaaaaaaa"
            }
        }
    }

    private fun callingRequestApi(searchText: String) {
        viewModel.requestNewsApi(searchText)
    }

    private fun setupAdapter(resultNewsOfRequest: ModelNews?) {
        Log.i(TAG, "setupAdapter: $resultNewsOfRequest")
    }
}
