/*
 * Copyright (C) 2021 The Android Open Source Project.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.pbmgodeliva205411029

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.pbmgodeliva205411029.databinding.ListCatVaccineViewBinding

/**
 * This class implements a [RecyclerView] [ListAdapter] which uses Data Binding to present [List]
 * data, including computing diffs between lists.
 */
class CatVaccineAdapter :
    ListAdapter<CatVaccine, CatVaccineAdapter.CatVaccineViewHolder>(DiffCallback) {

    class CatVaccineViewHolder(
        private var binding: ListCatVaccineViewBinding
    ) : RecyclerView.ViewHolder(binding.root){
        fun bind(catVaccine: CatVaccine) {
            binding.catVaccine = catVaccine
            binding.executePendingBindings()
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<CatVaccine>() {

        override fun areItemsTheSame(oldItem: CatVaccine, newItem: CatVaccine): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: CatVaccine, newItem: CatVaccine): Boolean {
            return oldItem.level == newItem.level && oldItem.description == newItem.description
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatVaccineViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return CatVaccineViewHolder(
            ListCatVaccineViewBinding.inflate(layoutInflater, parent, false)
        )
    }

    override fun onBindViewHolder(holder: CatVaccineViewHolder, position: Int) {
        val catVaccine = getItem(position)
        holder.bind(catVaccine)
    }
}
