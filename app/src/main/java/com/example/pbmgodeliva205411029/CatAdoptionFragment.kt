package com.example.pbmgodeliva205411029

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.pbmgodeliva205411029.databinding.FragmentCatAdoptionBinding

class CatAdoptionFragment : Fragment() {
    // define viewmodel yang akan digunakan
    private val viewModel: CatVaccineViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentCatAdoptionBinding.inflate(inflater)

        // mendapatkan value dari livedata yang ada di viewmodel
        viewModel.getCatAdoptionList()
        // define data dari livedata pada binding (fragment ini)
        binding.lifecycleOwner = this
        // define viewmodel
        binding.viewModel = viewModel
        // set layout pada recyclerview dengan menggunakan grid (2 kolom)
        binding.recyclerView.layoutManager = GridLayoutManager(this.context, 2)
        // define adapter yang digunakan, beserta dengan action click pada list
        binding.recyclerView.adapter = CatAdoptionAdapter(CatAdoptionListener { catAdoption ->
            viewModel.onCatAdoptionClicked(catAdoption)
            // perpindahan dari fragment recyclerview ke detail fragment
            findNavController()
                .navigate(R.id.action_CatAdoptionFragment_to_CatAdoptionDetailFragment)
        })

        // Inflate the layout for this fragment
        return binding.root
    }
}