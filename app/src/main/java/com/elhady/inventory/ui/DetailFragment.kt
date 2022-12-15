package com.elhady.inventory.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.elhady.inventory.R
import com.elhady.inventory.databinding.FragmentDetailBinding
import com.elhady.inventory.viewmodel.SharedViewModel


class DetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailBinding
    private val sharedViewModel: SharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_detail, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            detailFragment = this@DetailFragment
            viewModel = sharedViewModel
        }
    }

    fun navigateBackToList(){
        findNavController().navigate(R.id.action_detailFragment_to_shoeListFragment)
    }

    fun saveButton(){
        sharedViewModel.addShoe()
        findNavController().navigate(R.id.action_detailFragment_to_shoeListFragment)
    }
}