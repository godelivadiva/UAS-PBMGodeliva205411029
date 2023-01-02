package com.example.pbmgodeliva205411029

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Header

// variable untuk menyimpan URL API (endpoint diinputkan ke GET)
    private const val URL_API = "https://63afb929649c73f572c113ad.mockapi.io/api/v1/"

//Moshi adalah sebuah converter yang mana memudahkan parse JSON
private val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

// Retrofit relatif mudah untuk mengambil dan mengunggah JSON melalui webservice berbasis REST
// Retrofit moshi untuk menconvert data dari API ke format JSON
private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(URL_API)
    .build()

interface CatVaccineApiService {
    // endpoint untuk cat vaccine
    @GET("cat_vaccine")
    // Implementasi antarmuka CatVaccineApiService dengan fungsi suspend
    // untuk mendapatkan daftar vaccine
    suspend fun getCatVaccines(): List<CatVaccine>
}

interface CatAdoptionApiService {
    // endpoint untuk adoption list
    @GET("cat_adoption_list")
    // Implementasi antarmuka CatAdoptionApiService dengan fungsi suspend
    // untuk mendapatkan daftar adoption
    suspend fun getCatAdoptions(): List<CatAdoption>
}

// untuk mengekspos layanan Retrofit untuk Vaccine
object CatVaccineApi {
    val service: CatVaccineApiService by lazy {
        retrofit.create(CatVaccineApiService::class.java)
    }
}

// untuk mengekspos layanan Retrofit untuk Adopt
object CatAdoptionApi {
    val service: CatAdoptionApiService by lazy {
        retrofit.create(CatAdoptionApiService::class.java)
    }
}