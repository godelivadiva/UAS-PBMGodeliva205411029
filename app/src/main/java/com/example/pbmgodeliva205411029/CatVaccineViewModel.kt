package com.example.pbmgodeliva205411029

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class CatVaccineViewModel: ViewModel() {

    // TODO: Create properties to represent MutableLiveData and LiveData for a list of amphibian objects
    // Menampilkan daftar amphibi untuk List dengan menggunakan MutableLiveData dan LiveData
    private val _catVaccines = MutableLiveData<List<CatVaccine>>()
    val catVaccines: LiveData<List<CatVaccine>> = _catVaccines

    private val _catAdoptions = MutableLiveData<List<CatAdoption>>()
    val catAdoptions: LiveData<List<CatAdoption>> = _catAdoptions

    private val _catAdoption = MutableLiveData<CatAdoption>()
    val catAdoption: LiveData<CatAdoption> = _catAdoption

    // TODO: Create a function that gets a list of amphibians from the api service and sets the
    //  status via a Coroutine
    // Untuk mendapatkan list Amphibian dari API
    fun getCatVaccineList() {
        // Menggunakan try-catch untuk menangani error (data akan kosong alih-alih force close)
        viewModelScope.launch {
            try {
                _catVaccines.value = CatVaccineApi.service.getCatVaccines()
            } catch (e: Exception) {
                _catVaccines.value = emptyList()
            }
        }
    }

    fun getCatAdoptionList() {
        // Menggunakan try-catch untuk menangani error (data akan kosong alih-alih force close)
        viewModelScope.launch {
            try {
                _catAdoptions.value = CatAdoptionApi.service.getCatAdoptions()
            } catch (e: Exception) {
                _catAdoptions.value = emptyList()
            }
        }
    }

    //  fungsi yang akan dipanggil ketika Amphibian di click
    fun onCatAdoptionClicked(catAdoption: CatAdoption) {
        // TODO: Set the amphibian object
        // Amphibian yang dipilih akan ditampilkan pada detail
        _catAdoption.value = catAdoption
    }

}