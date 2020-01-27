package com.example.mvvmwithoutdatabinding.ui

import androidx.lifecycle.ViewModel
import com.example.mvvmwithoutdatabinding.data.Quote
import com.example.mvvmwithoutdatabinding.data.QuoteRepository

class QuotesViewModel(private val quoteRepository: QuoteRepository): ViewModel(){

    fun getQuotes() = quoteRepository.getQuotes()
    fun addQuotes(quote: Quote) = quoteRepository.addQuote(quote)
}
