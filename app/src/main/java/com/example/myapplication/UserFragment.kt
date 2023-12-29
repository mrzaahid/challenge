package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.myapplication.databinding.FragmentHomeBinding
import com.example.myapplication.databinding.FragmentUserBinding
import com.zaahid.challenge4.utils.viewModelFactory


class UserFragment : Fragment() {
    private lateinit var binding : FragmentUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentUserBinding.inflate(layoutInflater)

        return binding.root
    }
    private val viewModel : MainViewModel by viewModelFactory {
        MainViewModel(ServiceLocator.provideUserPreferenceDataSource(binding.root.context))
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.textView2.text = viewModel.getUsername().toString()
        binding.button.setOnClickListener {
            findNavController().navigate(R.id.action_userFragment_to_userListFragment)
        }
    }
}