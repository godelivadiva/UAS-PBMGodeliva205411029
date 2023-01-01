package com.example.pbmgodeliva205411029

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.pbmgodeliva205411029.databinding.FragmentCatAdoptionDetailBinding

/**
 * A simple [Fragment] subclass.
 * Use the [CatAdoptionDetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CatAdoptionDetailFragment : Fragment() {

    private val viewModel: CatVaccineViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentCatAdoptionDetailBinding.inflate(inflater)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        // Inflate the layout for this fragment
        return binding.root
    }
}