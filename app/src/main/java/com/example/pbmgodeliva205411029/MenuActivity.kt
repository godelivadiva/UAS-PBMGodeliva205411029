package com.example.pbmgodeliva205411029

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import com.example.pbmgodeliva205411029.databinding.ActivityMenuBinding

class MenuActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var ibAboutMe : ImageButton
    private lateinit var ibVaccine : ImageButton
    private lateinit var ibAdoptMe : ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        ibAboutMe = binding.ibAboutMe
        ibAboutMe.setOnClickListener(this)
        ibVaccine = binding.ibVaccine
        ibVaccine.setOnClickListener(this)
        ibAdoptMe = binding.ibAdoptMe
        ibAdoptMe.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if (v != null) {
            when(v.id) {
                R.id.ibAboutMe -> run {
                    val intentAboutMe = Intent(this@MenuActivity, AboutMeActivity::class.java)
                    startActivity(intentAboutMe)
                }
                R.id.ibVaccine -> run {
                    val intentVaccine = Intent(this@MenuActivity, CatVaccineActivity::class.java)
                    startActivity(intentVaccine)
                }
                R.id.ibAdoptMe -> run {
                    val intentVaccine = Intent(this@MenuActivity, CatAdoptionActivity::class.java)
                    startActivity(intentVaccine)
                }
            }
        }
    }
}
