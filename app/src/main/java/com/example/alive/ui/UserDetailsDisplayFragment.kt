package com.example.alive.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.Person.fromBundle
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.alive.databinding.UserDetailFragmentBinding
import dagger.hilt.EntryPoint
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UserDetailsDisplayFragment :Fragment(){

    private val TAG : String = UserDetailsDisplayFragment::class.java.simpleName

    @SuppressLint("UseRequireInsteadOfGet")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val safeArgs = UserDetailsDisplayFragmentArgs.fromBundle(arguments!!)
        val user = safeArgs.user
        Log.d(TAG,"onCreateView === ${user.fname}")
        val binding = UserDetailFragmentBinding.inflate(layoutInflater)
        binding?.txtFname.text = user.fname
        binding?.txtLname.text = user.lname
        binding?.txtAge.text = user.age

        return binding.root
    }
}