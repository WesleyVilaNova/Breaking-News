package com.example.newsinformed.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.newsinformed.repository.api.NewsRepository
import com.example.newsinformed.repository.models.ModelNews
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.HttpException
import retrofit2.await

class HomeNewsViewModel(private val newsRepository: NewsRepository) : ViewModel() {

    private val _newsResult = MutableLiveData<ModelNews>()
    val newsResult: LiveData<ModelNews> get() = _newsResult

    private val _errorMsg = MutableLiveData<String>()
    val errorMsg: LiveData<String> get() = _errorMsg

    fun requestNewsApi(searchText: String) {
        try {
            CoroutineScope(Dispatchers.IO).launch {
                val resultNewsOfRequest = newsRepository.getNewsRepository(searchText).await()
                _newsResult.postValue(resultNewsOfRequest)
            }
        } catch (e: HttpException) {
            _errorMsg.value = e.code().toString()
        }
    }

    class MyHomeViewModelFactory(private val newsRepository: NewsRepository) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return if (modelClass.isAssignableFrom(HomeNewsViewModel::class.java)) {
                HomeNewsViewModel(this.newsRepository) as T
            } else {
                throw IllegalArgumentException("ViewModel not Found")
            }
        }
    }
}
