package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication.databinding.FragmentUserListBinding
import com.example.myapplication.databinding.FragmentUserListListBinding
import com.example.myapplication.placeholder.PlaceholderContent
import com.zaahid.challenge4.utils.viewModelFactory

/**
 * A fragment representing a list of Items.
 */
class UserListFragment : Fragment() {
    private lateinit var binding: FragmentUserListListBinding
    private lateinit var RVAdapter : MyuserRecyclerViewAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentUserListListBinding.inflate(inflater)
        return binding.root
    }
    private val viewModel : MainViewModel by viewModelFactory {
        MainViewModel(ServiceLocator.provideUserPreferenceDataSource(binding.root.context))
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var listUser = viewModel.getUsers(1,5)
        if (listUser!=null){
            RVAdapter.submitData(listUser.data)
            binding.list.apply {
                layoutManager = LinearLayoutManager(view.context,LinearLayoutManager.VERTICAL,false)
                adapter =this@UserListFragment.RVAdapter
            }
        }


    }


}