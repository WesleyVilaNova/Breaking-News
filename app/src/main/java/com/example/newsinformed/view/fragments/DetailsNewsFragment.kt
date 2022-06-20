package com.example.newsinformed.view.fragments

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.newsinformed.R
import com.example.newsinformed.databinding.FragmentDetailsNewsBinding
import java.text.SimpleDateFormat
import java.util.*

class DetailsNewsFragment : Fragment(R.layout.fragment_details_news) {

    private lateinit var binding: FragmentDetailsNewsBinding
    private val args by navArgs<DetailsNewsFragmentArgs>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = FragmentDetailsNewsBinding.bind(view)

        setupViewDetailsNews()
        btnClickUrl()
    }

    private fun setupViewDetailsNews() {
        val date = Calendar.getInstance().time
        val dateFormat = SimpleDateFormat("dd MMM yyyy", Locale.getDefault())
        try {
            binding.textViewDescription.text = args.recebendoDadosDoHome.description
            binding.textViewDate.text = dateFormat.format(date)
            Glide.with(this)
                .load(args.recebendoDadosDoHome.urlToImage)
                .error(R.drawable.splash_logo)
                .fallback(R.drawable.splash_logo)
                .into(binding.imageViewDetailsNews)
        } catch (e: Exception) {
            Log.i("TAG", "setupViewDetailsNews: ${e.cause}")
        }
    }

    private fun btnClickUrl() {
        binding.btnKnowMore.setOnClickListener {
            Toast.makeText(context, "Clicked", Toast.LENGTH_LONG).show()
        }
    }
}
