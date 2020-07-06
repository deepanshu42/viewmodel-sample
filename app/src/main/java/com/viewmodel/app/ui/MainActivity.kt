package com.viewmodel.app.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.viewmodel.app.R
import com.viewmodel.app.viewmodel.CounterViewModel
import com.viewmodel.app.viewmodel.factory.ViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: CounterViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        hashcode.text = this.hashCode().toString()
        setupViewModel()
        setUpListeners()
    }

    private fun setupViewModel() {
        viewModel = ViewModelProvider(this, ViewModelFactory()).get(CounterViewModel::class.java)
        viewModel.liveData.observe(this, Observer {
            counter.text = it.toString()
        })
    }

    private fun setUpListeners() {
        increment.setOnClickListener {
            viewModel.increment()
        }
        decrement.setOnClickListener {
            viewModel.decrement()
        }
    }
}
