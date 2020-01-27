package com.example.mvvmwithoutdatabinding.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmwithoutdatabinding.data.QuoteRepository

@Suppress("UNCHECKED_CAST")
class QuoteViewModelFactory(private val quoteRepository: QuoteRepository): ViewModelProvider.NewInstanceFactory(){

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return QuotesViewModel(quoteRepository) as T
    }
}