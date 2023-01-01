package com.example.pbmgodeliva205411029

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.pbmgodeliva205411029.databinding.FragmentCatVaccineBinding

/**
 * A simple [Fragment] subclass.
 * Use the [CatVaccineFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CatVaccineFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private val viewModel: CatVaccineViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentCatVaccineBinding.inflate(inflater)

        viewModel.getCatVaccineList()
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        binding.recyclerView.adapter = CatVaccineAdapter()

        return binding.root
    }
}