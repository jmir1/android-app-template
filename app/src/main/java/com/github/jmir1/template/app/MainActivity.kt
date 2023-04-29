package com.github.jmir1.template.app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.jmir1.template.app.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var counter = 0

        binding.buttonCompute.setOnClickListener {
            counter++
            binding.textResult.text = counter.toString()
        }
    }
}
