package com.rahul.learningmvvm.mvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.rahul.learningmvvm.R
import com.rahul.learningmvvm.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    private lateinit var repo: QuotesRepository
    private lateinit var dao: QuoteDao
    lateinit var  binding:ActivityMain2Binding
    lateinit var mainViewModel:MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main2)
        dao = QuoteDatabase.getDatabase(applicationContext).quoteDAO()
        repo = QuotesRepository(dao)
        mainViewModel = ViewModelProvider(this,MainViewModelFactory(quoteRepo = repo)).get(MainViewModel::class.java)

        mainViewModel.getQuotes().observe(this, Observer {
            binding.quotes = it.toString()
        })



        binding.btnAdd.setOnClickListener {
            val quote = Quote(0,"This is testing","Testing")
            mainViewModel.insertQuote(quote)
        }
    }
}