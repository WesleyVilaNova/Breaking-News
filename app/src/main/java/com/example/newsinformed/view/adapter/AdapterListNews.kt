package com.example.newsinformed.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.newsinformed.R
import com.example.newsinformed.databinding.ItemListNewsBinding
import com.example.newsinformed.repository.models.ModelListResult

class AdapterListNews(val context: Context) :
    ListAdapter<ModelListResult, AdapterListNews.MyViewHolder>(DiffCallback()) {

    class MyViewHolder(val binding: ItemListNewsBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(ItemListNewsBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val itemNews = getItem(position)

        Glide.with(context)
            .load(itemNews.urlToImage)
            .error(R.drawable.splash_logo)
            .fallback(R.drawable.splash_logo)
            .into(holder.binding.imageViewUrl)

        try {
            itemNews?.let {
                holder.binding.textTitle.text = itemNews.title
                holder.binding.textViewContent.text = itemNews.content
                holder.binding.textViewName.text = itemNews.source.name
                holder.binding.textViewPublishedAt.text = itemNews.publishedAt
            }
        } catch (e: Exception) {
            e.fillInStackTrace()
        }
    }
}

class DiffCallback : DiffUtil.ItemCallback<ModelListResult>() {
    override fun areItemsTheSame(oldItem: ModelListResult, newItem: ModelListResult): Boolean {
        return oldItem.title == newItem.title
    }

    override fun areContentsTheSame(oldItem: ModelListResult, newItem: ModelListResult): Boolean {
        return oldItem.description == newItem.description
    }
}
