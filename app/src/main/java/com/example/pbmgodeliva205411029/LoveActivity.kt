package com.example.pbmgodeliva205411029

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.pbmgodeliva205411029.databinding.ActivityLoveBinding

class LoveActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoveBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoveBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

    }
}