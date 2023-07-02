package com.example.expandablerecyclerviewadapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.expandablerecyclerviewadapter.databinding.ItemBinding

class ItemAdapter(
    private val itemList: List<Item>
) : ListAdapter<Item, ItemAdapter.ItemViewHolder>(DiffCallback()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val itemBinding = ItemBinding.inflate(inflater, parent, false)
        return ItemViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = itemList[position]
        holder.binding.itemName.text = item.name
        holder.binding.itemCompany.text = item.company

        val subListAdapter = SubListAdapter(item.subItems)
        holder.binding.subRecyclerView.adapter = subListAdapter
//        val layoutManager = LinearLayoutManager(
//            holder.binding.root.context,
//            LinearLayoutManager.HORIZONTAL,
//            false)
//        holder.binding.subRecyclerView.layoutManager = layoutManager

        holder.binding.itemLayout.setOnClickListener {
            if (holder.binding.subRecyclerView.isVisible){
                holder.binding.subRecyclerView.visibility = View.GONE
            } else{
                holder.binding.subRecyclerView.visibility = View.VISIBLE
            }
        }

    }

    override fun getItemCount() = itemList.size

    class DiffCallback : DiffUtil.ItemCallback<Item>() {
        override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean {
            return oldItem.name == newItem.name && oldItem.company == newItem.company
        }
    }
    class ItemViewHolder(var binding: ItemBinding) : RecyclerView.ViewHolder(binding.root)
}