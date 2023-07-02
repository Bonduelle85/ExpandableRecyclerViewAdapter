package com.example.expandablerecyclerviewadapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.expandablerecyclerviewadapter.databinding.ItemChildListBinding

class SubListAdapter(val subList: List<String> = mutableListOf()): ListAdapter<String, SubListAdapter.SubListViewHolder>(SubListAdapter.DiffCallback())  {


    class SubListViewHolder (var binding: ItemChildListBinding): RecyclerView.ViewHolder(binding.root)

    class DiffCallback: DiffUtil.ItemCallback<String>() {
        override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem == newItem
        }
        override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem == newItem
        }

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubListViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val itemChildListBinding = ItemChildListBinding.inflate(inflater, parent, false)
        return SubListViewHolder(itemChildListBinding)
    }

    override fun onBindViewHolder(holder: SubListViewHolder, position: Int) {
        val subItem = subList[position]
        holder.binding.subListText.text =subItem
    }

    override fun getItemCount() = subList.size
}