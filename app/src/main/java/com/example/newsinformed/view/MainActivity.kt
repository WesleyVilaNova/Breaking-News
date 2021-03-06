package com.example.newsinformed.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.newsinformed.R
import com.example.newsinformed.databinding.ActivityMainBinding
import com.example.newsinformed.repository.api.IWebService
import com.example.newsinformed.repository.api.NewsRepository
import com.example.newsinformed.viewmodel.HomeNewsViewModel

class MainActivity : AppCompatActivity() {

    private val viewModel: HomeNewsViewModel by viewModels {
        HomeNewsViewModel.MyHomeViewModelFactory(NewsRepository(IWebService.getInstance()))
    }
    private lateinit var binding: ActivityMainBinding
    private lateinit var navHostFragment: NavHostFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupObserversFragments()
        setupContainerFragments()
    }

    private fun setupObserversFragments() {
        viewModel.newsResult.observe(this) {
        }
        viewModel.errorMsg.observe(this) {
        }
    }

    private fun setupContainerFragments() {
        navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        val navController = navHostFragment.navController
        binding.bottomNavigationView.apply { setupWithNavController(navController) }
    }
}
