package com.example.pbmgodeliva205411029

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView


// Menampilkan list dari CatVaccineAdapter pada recyclerview
@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<CatVaccine>?) {
    val adapter = recyclerView.adapter as CatVaccineAdapter
    adapter.submitList(data)
}
