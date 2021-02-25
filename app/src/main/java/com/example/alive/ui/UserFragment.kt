package com.example.alive.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.example.alive.databinding.UserFragmentBinding
import com.example.alive.model.User
import com.example.alive.viewmodel.UserDetailViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.util.*


@AndroidEntryPoint
class UserFragment : Fragment(){

    private val userViewmodel: UserDetailViewModel by viewModels()
    var binding: UserFragmentBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = UserFragmentBinding.inflate(layoutInflater)
        binding?.datePikcer?.maxDate = System.currentTimeMillis()
        binding?.btnDone?.setOnClickListener {
            handleButtonClick(it);
        }
        return binding?.root
    }

    private fun handleButtonClick(view : View) {

        val fname = binding?.editFirstName?.text.toString()
        val lname = binding?.editLastName?.text.toString()

        if (userViewmodel.ValidateUser(fname,lname)){

            Toast.makeText(activity,"Please enter first name and last name",Toast.LENGTH_LONG).show()
        }else {


            val d =  binding?.datePikcer?.getDate()!!

            var differ = userViewmodel.calculateAge(d!!)!!

            val user = User(fname, lname, differ)

            // create an action and pass the the required user object to it
            // If you can not find the RegistrationDirection try to "Build project"
            val directions = UserFragmentDirections.actionFirstFragmentToSecondFragment(user)
            view.findNavController().navigate(directions)
        }
    }


    fun DatePicker.getDate(): Date {
        val calendar = Calendar.getInstance()
        calendar.set(year, month, dayOfMonth)
        return calendar.time
    }




}