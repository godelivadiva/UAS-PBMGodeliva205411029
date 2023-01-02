package com.example.pbmgodeliva205411029

import com.squareup.moshi.Json

// declare data apa saja yang akan diambil pada REST API
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
    // mengambil data dari json > image_url dan mendefine dengan nama imgSrcUrl
    // pastikan link image adalah berformat image
    @Json(name = "image_url") val imgSrcUrl: String
)
