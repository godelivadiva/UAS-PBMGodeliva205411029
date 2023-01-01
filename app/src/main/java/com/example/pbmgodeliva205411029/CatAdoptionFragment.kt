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
    // TODO: Rename and change types of parameters
    private val viewModel: CatVaccineViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentCatAdoptionBinding.inflate(inflater)

        viewModel.getCatAdoptionList()
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        binding.recyclerView.layoutManager = GridLayoutManager(this.context, 2)
        binding.recyclerView.adapter = CatAdoptionAdapter(CatAdoptionListener { catAdoption ->
            viewModel.onCatAdoptionClicked(catAdoption)
            findNavController()
                .navigate(R.id.action_CatAdoptionFragment_to_CatAdoptionDetailFragment)
        })

        return binding.root
    }
}