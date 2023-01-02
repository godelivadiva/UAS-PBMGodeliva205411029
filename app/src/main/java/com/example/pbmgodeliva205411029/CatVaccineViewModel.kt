package com.example.pbmgodeliva205411029

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class CatVaccineViewModel: ViewModel() {

    // Menampilkan daftar vaccine untuk List dengan menggunakan MutableLiveData dan LiveData
    private val _catVaccines = MutableLiveData<List<CatVaccine>>()
    val catVaccines: LiveData<List<CatVaccine>> = _catVaccines

    // Menampilkan daftar adoption untuk List dengan menggunakan MutableLiveData dan LiveData
    private val _catAdoptions = MutableLiveData<List<CatAdoption>>()
    val catAdoptions: LiveData<List<CatAdoption>> = _catAdoptions

    // Variabel ini akan digunakan untuk menyimpan pet yang dipilih dan ditampilkan di layar detail
    private val _catAdoption = MutableLiveData<CatAdoption>()
    val catAdoption: LiveData<CatAdoption> = _catAdoption

    // Untuk mendapatkan list Vaccine dari API
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

    // Untuk mendapatkan list pet adoption dari API
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

    //  fungsi yang akan dipanggil ketika salah satu pet di click
    fun onCatAdoptionClicked(catAdoption: CatAdoption) {
        _catAdoption.value = catAdoption
    }

}