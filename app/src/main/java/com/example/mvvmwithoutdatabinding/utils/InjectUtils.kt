package com.example.mvvmwithoutdatabinding.utils

import com.example.mvvmwithoutdatabinding.data.FakeDataBase
import com.example.mvvmwithoutdatabinding.data.QuoteRepository
import com.example.mvvmwithoutdatabinding.ui.QuoteViewModelFactory

object InjectUtils {


    //called from the
    fun provideQuotesViewModelFactory(): QuoteViewModelFactory {
        val quoteRepository = QuoteRepository.getInstance(FakeDataBase.getInstance().fakeQuoteDao)
        return QuoteViewModelFactory(quoteRepository)

    }


}