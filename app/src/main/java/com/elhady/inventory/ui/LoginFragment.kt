package com.elhady.inventory.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.elhady.inventory.R
import com.elhady.inventory.databinding.FragmentLoginBinding


class LoginFragment : Fragment() {

     private lateinit var  binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.loginFragment = this
    }

    /**
     * Navigate to the next screen and start welcome fragment.
     */
    fun navigateToWelcome(){
        findNavController().navigate(R.id.action_loginFragment_to_welcomeFragment)
    }


}