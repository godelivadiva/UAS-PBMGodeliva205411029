package com.example.pbmgodeliva205411029

import android.view.View
import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load

@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<CatAdoption>?) {
    val adapter = recyclerView.adapter as CatAdoptionAdapter
    adapter.submitList(data)
}

@BindingAdapter("imageUrl")
fun bindImage(imgView: ImageView, imgUrl: String?) {
    imgUrl?.let {
        // Load the image in the background using Coil.
        val imgUri = imgUrl.toUri().buildUpon().scheme("https").build()
        imgView.load(imgUri) {
            error(R.drawable.ic_broken_image)
    }
}
}