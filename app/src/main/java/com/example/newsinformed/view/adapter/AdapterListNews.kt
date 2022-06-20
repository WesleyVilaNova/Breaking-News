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
import com.example.newsinformed.repository.interfaces.OnClick
import com.example.newsinformed.repository.models.ModelListResult

class AdapterListNews(val context: Context, val _onClick: OnClick) :
    ListAdapter<ModelListResult, AdapterListNews.MyViewHolder>(DiffCallback()), OnClick {

    class MyViewHolder(val binding: ItemListNewsBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onClickNews(onClick: ModelListResult) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(ItemListNewsBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val itemNews = getItem(position)
        val format = itemNews.publishedAt.replaceRange(10, 20, "")

        holder.itemView.setOnClickListener { _onClick.onClickNews(itemNews) }

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
                holder.binding.textViewPublishedAt.text = format
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
