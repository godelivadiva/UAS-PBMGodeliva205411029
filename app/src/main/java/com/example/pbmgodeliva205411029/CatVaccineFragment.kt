package com.example.pbmgodeliva205411029

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.pbmgodeliva205411029.databinding.FragmentCatVaccineBinding

class CatVaccineFragment : Fragment() {
    // define viewmodel yang akan digunakan
    private val viewModel: CatVaccineViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentCatVaccineBinding.inflate(inflater)

        viewModel.getCatVaccineList()
        // define data dari livedata pada binding (fragment ini)
        binding.lifecycleOwner = this
        // define viewmodel
        binding.viewModel = viewModel
        // define adapter
        binding.recyclerView.adapter = CatVaccineAdapter()

        // Inflate the layout for this fragment
        return binding.root
    }
}