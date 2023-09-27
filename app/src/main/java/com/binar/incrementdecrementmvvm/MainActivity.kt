package com.binar.incrementdecrementmvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.binar.incrementdecrementmvvm.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val viewModel: MainViewModel by lazy {
        ViewModelProvider(this)[MainViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setOnClickListener()
        observeState()
    }

    private fun observeState() {
        viewModel.counter.observe(this) {
            binding.tvCounter.text = it.toString()
        }
        viewModel.price.observe(this) {
            binding.tvTotalPriceValue.text = "IDR ${it}"
        }
    }


    private fun setOnClickListener() {
        binding.btnDecrement.setOnClickListener {
            decrement()
        }
        binding.btnIncrement.setOnClickListener {
            increment()
        }
    }

    private fun decrement() {
        viewModel.decrement()
    }

    private fun increment() {
        viewModel.increment()
    }


}