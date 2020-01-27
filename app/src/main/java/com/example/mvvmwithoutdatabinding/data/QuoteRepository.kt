package com.example.mvvmwithoutdatabinding.data

class QuoteRepository private constructor(private val fakeQuoteDao: FakeQuoteDao) {

    companion object {
        @Volatile
        private var instance: QuoteRepository? = null

        fun getInstance(fakeQuoteDao: FakeQuoteDao) = instance ?: synchronized(this) {
            instance ?: QuoteRepository(fakeQuoteDao).also { instance = it }
        }
    }


    fun addQuote(quote: Quote) {
        fakeQuoteDao.addQuote(quote)
    }

    // will return the data which is present in Dao class
    fun getQuotes() = fakeQuoteDao.getQuotes()
}