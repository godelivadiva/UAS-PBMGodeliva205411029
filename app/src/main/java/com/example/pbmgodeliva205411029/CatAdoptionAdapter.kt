package com.example.pbmgodeliva205411029

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.pbmgodeliva205411029.databinding.ListCatAdoptionViewBinding
import com.example.pbmgodeliva205411029.databinding.ListCatVaccineViewBinding


/**
 * This class implements a [RecyclerView] [ListAdapter] which uses Data Binding to present [List]
 * data, including computing diffs between lists.
 */
class CatAdoptionAdapter(val clickListener: CatAdoptionListener) :
    ListAdapter<CatAdoption, CatAdoptionAdapter.CatAdoptionViewHolder>(DiffCallback) {

    class CatAdoptionViewHolder(
        private var binding: ListCatAdoptionViewBinding
    ) : RecyclerView.ViewHolder(binding.root){
        fun bind(clickListener: CatAdoptionListener, catAdoption: CatAdoption) {
            binding.catAdoption = catAdoption
            binding.clickListener = clickListener
            binding.executePendingBindings()
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<CatAdoption>() {

        override fun areItemsTheSame(oldItem: CatAdoption, newItem: CatAdoption): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: CatAdoption, newItem: CatAdoption): Boolean {
            return oldItem.age == newItem.age && oldItem.description == newItem.description
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatAdoptionViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return CatAdoptionViewHolder(
            ListCatAdoptionViewBinding.inflate(layoutInflater, parent, false)
        )
    }

    override fun onBindViewHolder(holder: CatAdoptionViewHolder, position: Int) {
        val catAdoption = getItem(position)
        holder.bind(clickListener, catAdoption)
    }
}

class CatAdoptionListener(val clickListener: (catAdoption: CatAdoption) -> Unit) {
    fun onClick(catAdoption: CatAdoption) = clickListener(catAdoption)
}