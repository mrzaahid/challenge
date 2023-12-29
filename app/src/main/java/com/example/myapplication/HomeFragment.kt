package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.appcompat.app.AlertDialog
import androidx.navigation.fragment.findNavController

import com.example.myapplication.databinding.FragmentHomeBinding
import com.google.android.material.snackbar.Snackbar
import com.zaahid.challenge4.utils.viewModelFactory


class HomeFragment : Fragment() {
    private lateinit var binding :FragmentHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(layoutInflater)

        return binding.root
    }
    private val viewModel : MainViewModel by viewModelFactory {
        MainViewModel(ServiceLocator.provideUserPreferenceDataSource(binding.root.context))
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.window?.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)

        binding.buttoncheck.setOnClickListener {
            val builder = AlertDialog.Builder(binding.root.context)
            if (isPalindrome(binding.ETPolindrome.text.toString())){
                builder.setMessage("isPalindrome")
            }else{
                builder.setMessage("Not Palindrome ")
            }
            builder.setCancelable(true)
            val alertDialog = builder.create()
            alertDialog.show()
        }
        binding.button2.setOnClickListener {
            if (!binding.ETName.text.isNullOrEmpty()){
                viewModel.setUsername(binding.ETName.text.toString())
                Snackbar.make(binding.view,"WELCOME"+viewModel.getUsername(),Snackbar.LENGTH_LONG ).show()
                activity?.window?.clearFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
                findNavController().navigate(R.id.action_homeFragment_to_userFragment)
            }else{
                Snackbar.make(binding.view,"You Should do the name first sir!",Snackbar.LENGTH_LONG ).show()
            }
        }
    }

    private fun isPalindrome(str: String) : Boolean{
        val reversedStr = str.reversed()
        return str == reversedStr
    }
}