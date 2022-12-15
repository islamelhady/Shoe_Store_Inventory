package com.elhady.inventory.ui

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.elhady.inventory.R
import com.elhady.inventory.databinding.FragmentShoeListBinding
import com.elhady.inventory.databinding.ItemShoeBinding
import com.elhady.inventory.viewmodel.SharedViewModel


class ShoeListFragment : Fragment() {

    private lateinit var binding: FragmentShoeListBinding
    private val sharedViewModel: SharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_list, container, false)
        setHasOptionsMenu(true)
        observeListShoe(inflater, container)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.shoeList = this
    }

    fun navigateToDetails() {
        sharedViewModel.initShoe()
        findNavController().navigate(R.id.action_shoeListFragment_to_detailFragment)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        //handles navigate to login
        return NavigationUI.onNavDestinationSelected(item, requireView().findNavController()) ||
                super.onOptionsItemSelected(item)
    }

     // fun responsible for observing item in shoe list,
    private fun observeListShoe(inflater: LayoutInflater, container: ViewGroup?) {
         sharedViewModel.shoeList.observe(viewLifecycleOwner, Observer { shoeList ->
            if (shoeList.isNotEmpty()) {
                binding.emptyText.visibility = View.GONE
            }
            shoeList.forEach { shoe ->
                // Inflating the shoe item list layout
                val bindingItem: ItemShoeBinding =
                    DataBindingUtil.inflate(inflater, R.layout.item_shoe, container, false)

                bindingItem.shoe = shoe
                binding.listShoe.addView(bindingItem.root)
            }
        })
    }
}