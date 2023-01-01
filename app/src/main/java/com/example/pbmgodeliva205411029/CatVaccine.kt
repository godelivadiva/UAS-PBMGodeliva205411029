package com.example.pbmgodeliva205411029

import android.widget.ImageView
import com.squareup.moshi.Json

data class CatVaccine(
    val level: String,
    val age: String,
    val name: String,
    val description: String,
    val additional: String,
)

data class CatAdoption(
    val age: String,
    val name: String,
    val description: String,
    @Json(name = "image_url") val imgSrcUrl: String
)
