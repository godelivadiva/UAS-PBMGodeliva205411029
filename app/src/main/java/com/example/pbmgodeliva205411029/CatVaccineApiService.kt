package com.example.pbmgodeliva205411029

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Header

// TODO: Create a property for the base URL provided in the codelab
// variable untuk menyimpan URL dasar daftar amphibi (detail json diinputkan ke GET)
    private const val URL_API = "https://63afb929649c73f572c113ad.mockapi.io/api/v1/"

// TODO: Build the Moshi object with Kotlin adapter factory that Retrofit will be using to parse JSON
//Moshi adalah sebuah converter yang mana memudahkan parse JSON
private val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(URL_API)
    .build()

interface CatVaccineApiService {
    // TODO: Declare a suspended function to get the list of amphibians
    // untuk mendapatkan daftar amphibi json
    @GET("cat_vaccine")
    // Implementasi antarmuka AmphibianApiService dengan fungsi suspend
    // untuk mendapatkan daftar amphibi
    suspend fun getCatVaccines(): List<CatVaccine>
}

interface CatAdoptionApiService {
    // TODO: Declare a suspended function to get the list of amphibians
    // untuk mendapatkan daftar amphibi json
    @GET("cat_adoption_list")
    // Implementasi antarmuka AmphibianApiService dengan fungsi suspend
    // untuk mendapatkan daftar amphibi
    suspend fun getCatAdoptions(): List<CatAdoption>
}

// TODO: Create an object that provides a lazy-initialized retrofit service
// untuk mengekspos layanan Retrofit
object CatVaccineApi {
    // Increase android layout rendering performance
    val service: CatVaccineApiService by lazy {
        retrofit.create(CatVaccineApiService::class.java)
    }
}
object CatAdoptionApi {
    // Increase android layout rendering performance
    val service: CatAdoptionApiService by lazy {
        retrofit.create(CatAdoptionApiService::class.java)
    }
}