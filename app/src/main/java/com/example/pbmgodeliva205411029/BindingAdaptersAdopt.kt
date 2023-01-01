package com.example.pbmgodeliva205411029

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView

@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<CatAdoption>?) {
    val adapter = recyclerView.adapter as CatAdoptionAdapter
    adapter.submitList(data)
}