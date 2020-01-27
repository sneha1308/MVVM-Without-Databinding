package com.example.mvvmwithoutdatabinding.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.mvvmwithoutdatabinding.R
import com.example.mvvmwithoutdatabinding.data.Quote
import com.example.mvvmwithoutdatabinding.utils.InjectUtils
import kotlinx.android.synthetic.main.activity_quote.*

class QuotesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quote)
        initializeUi()
    }

    private fun initializeUi() {
        val factory = InjectUtils.provideQuotesViewModelFactory()

        // getting  quoteviewModel
        val viewModel = ViewModelProviders.of(this, factory)
            .get(QuotesViewModel::class.java)

        //finally observe the livedate for the Quotes
        viewModel.getQuotes().observe(this, Observer { quotes ->
            val sb = StringBuffer()
            quotes.forEach { quotes ->
                sb.append("$quotes\n\n")
            }

            tvQuote.text = sb.toString()
        })

        btnAddQuote.setOnClickListener {
            val quote = Quote(etQuote.text.toString(), etAuthor.text.toString())
            viewModel.addQuotes(quote)
            etQuote.setText("")
            etAuthor.setText("")
        }


    }
}
