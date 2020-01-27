package com.example.mvvmwithoutdatabinding.data

class FakeDataBase private constructor() {

    var fakeQuoteDao = FakeQuoteDao()

    companion object {
        @Volatile
        private var instance: FakeDataBase? = null

        fun getInstance() = instance ?: synchronized(this) {
            instance ?: FakeDataBase().also { instance = it }
        }
    }
}
