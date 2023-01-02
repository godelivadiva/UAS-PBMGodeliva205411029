package com.example.pbmgodeliva205411029

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.pbmgodeliva205411029.databinding.ActivityAboutMeBinding

class AboutMeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityAboutMeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // menyembunyikan action bar
        supportActionBar?.hide()

    }
}