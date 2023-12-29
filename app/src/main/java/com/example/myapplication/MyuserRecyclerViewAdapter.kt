package com.example.myapplication

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

import com.example.myapplication.placeholder.PlaceholderContent.PlaceholderItem
import com.example.myapplication.databinding.FragmentUserListBinding
import com.example.myapplication.databinding.FragmentUserListListBinding
import com.example.myapplication.modal.User


class MyuserRecyclerViewAdapter(
    private val values: List<User>
) : RecyclerView.Adapter<MyuserRecyclerViewAdapter.ItemViewHolder>() {

    private val diffCallback = object : DiffUtil.ItemCallback<User>(){
        override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
            return oldItem.id == newItem.id
        }
        override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
            return oldItem.hashCode() == newItem.hashCode()
        }
    }
    private val differ = AsyncListDiffer(this,diffCallback)

    fun submitData (value: List<User>)= differ.submitList(value)

    override fun onCreateViewHolder(parent: ViewGroup, viewType : Int): ItemViewHolder {
        val binding =
            FragmentUserListBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return  ItemViewHolder(binding)
    }
    class ItemViewHolder(val binding: FragmentUserListBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        with(holder){
            with(differ.currentList[position]){
                binding.itemNumber.text = this.firstname+this.lastname
                binding.content.text = this.email
                Glide.with(binding.root)
                    .load(this.avatar)
                    .apply(RequestOptions()
                        .error(R.drawable.background))
                    .into(binding.imageView)
            }
        }
    }

    override fun getItemCount(): Int = differ.currentList.size
}