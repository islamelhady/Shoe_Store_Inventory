package com.elhady.inventory.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.elhady.inventory.R
import com.elhady.inventory.databinding.FragmentInstructionsBinding


class InstructionsFragment : Fragment() {

    lateinit var binding: FragmentInstructionsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_instructions, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.instructionFragment = this
    }

    fun navigateToShoeList() {
        findNavController().navigate(R.id.action_instructionsFragment_to_shoeListFragment)
    }

}