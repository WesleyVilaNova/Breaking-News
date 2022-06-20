package com.example.newsinformed.view.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newsinformed.R
import com.example.newsinformed.databinding.FragmentHomeListNewsBinding
import com.example.newsinformed.repository.interfaces.OnClick
import com.example.newsinformed.repository.models.ModelListResult
import com.example.newsinformed.repository.models.ModelNews
import com.example.newsinformed.view.adapter.AdapterListNews
import com.example.newsinformed.viewmodel.HomeNewsViewModel

class HomeNewsFragment : Fragment(R.layout.fragment_home_list_news), OnClick {

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
        callingRequestApi(getString(R.string.text_search_init))
    }

    private fun setupEditTextHome() {
        binding.editTextHome.setOnClickListener {
            val searchText = binding.editTextHome.text.toString()
            if (searchText.isNotEmpty()) {
                callingRequestApi(searchText)
                binding.editTextHome.text.clear()
            } else {
                binding.editTextHome.error = getString(R.string.mensage_error_edit_text)
            }
        }
    }

    private fun callingRequestApi(searchText: String) {
        viewModel.requestNewsApi(searchText)
    }

    private fun setupAdapter(resultNewsOfRequest: ModelNews?) {
        binding.recyclerListNews.layoutManager = LinearLayoutManager(context)
        binding.recyclerListNews.setHasFixedSize(true)
        val adapter = context?.let { AdapterListNews(it.applicationContext, this) }
        adapter?.submitList(resultNewsOfRequest?.articles)
        binding.recyclerListNews.adapter = adapter
    }

    override fun onClickNews(onClick: ModelListResult) {
        val action = HomeNewsFragmentDirections.actionHomeNewsFragmentToDetailsNewsFragment(onClick)
        findNavController().navigate(action)
    }
}
