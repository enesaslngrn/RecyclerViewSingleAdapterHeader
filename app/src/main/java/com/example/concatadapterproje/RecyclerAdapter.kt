package com.example.concatadapterproje

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.concatadapterproje.databinding.HeaderRowBinding
import com.example.concatadapterproje.databinding.ItemRowBinding
import com.example.concatadapterproje.model.DataItem
import com.example.concatadapterproje.model.Database.TYPE_HEADER
import com.example.concatadapterproje.model.Database.TYPE_ITEM
import com.shuhart.stickyheader.StickyAdapter

class RecyclerAdapter(private val totalList: ArrayList<DataItem>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    inner class ItemViewHolder(val binding: ItemRowBinding) : RecyclerView.ViewHolder(binding.root)
    inner class HeaderViewHolder(val binding: HeaderRowBinding) : RecyclerView.ViewHolder(binding.root)

    override fun getItemCount(): Int {
        return totalList.size
    }

    override fun getItemViewType(position: Int): Int {
        return when (totalList[position]) {
            is DataItem.Header -> TYPE_HEADER
            is DataItem.Item -> TYPE_ITEM
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            TYPE_ITEM -> ItemViewHolder(ItemRowBinding.inflate(LayoutInflater.from(parent.context), parent, false))
            TYPE_HEADER -> HeaderViewHolder(HeaderRowBinding.inflate(LayoutInflater.from(parent.context), parent, false))
            else -> throw IllegalArgumentException("Invalid ViewType")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is ItemViewHolder -> {
                val item = totalList[position] as DataItem.Item
                holder.binding.tvItem.text = item.text
            }
            is HeaderViewHolder -> {
                val header = totalList[position] as DataItem.Header
                holder.binding.tvHeader.text = header.text
            }
        }
    }
}

/*
class RecyclerAdapter(private val totalList: ArrayList<DataItem>) : StickyAdapter<RecyclerView.ViewHolder, RecyclerView.ViewHolder>() {

    inner class ItemViewHolder(val binding: ItemRowBinding) : RecyclerView.ViewHolder(binding.root)
    inner class HeaderViewHolder(val binding: HeaderRowBinding) : RecyclerView.ViewHolder(binding.root)

    override fun getItemCount(): Int {
        return totalList.size
    }

    override fun getItemViewType(position: Int): Int {
        return when (totalList[position]) {
            is DataItem.Header -> TYPE_HEADER
            is DataItem.Item -> TYPE_ITEM
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            TYPE_ITEM -> ItemViewHolder(ItemRowBinding.inflate(LayoutInflater.from(parent.context), parent, false))
            TYPE_HEADER -> HeaderViewHolder(HeaderRowBinding.inflate(LayoutInflater.from(parent.context), parent, false))
            else -> throw IllegalArgumentException("Invalid ViewType")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is ItemViewHolder -> {
                val item = totalList[position] as DataItem.Item
                holder.binding.tvItem.text = item.text
                holder.itemView.setOnClickListener {
                    Toast.makeText(holder.itemView.context,"$item",Toast.LENGTH_SHORT).show()
                }
            }
            is HeaderViewHolder -> {
                val header = totalList[position] as DataItem.Header
                holder.binding.tvHeader.text = header.text
            }
        }

    }

    override fun getHeaderPositionForItem(itemPosition: Int): Int {
        for (i in itemPosition downTo 0) {
            if (getItemViewType(i) == TYPE_HEADER) {
                return i
            }
        }
        return RecyclerView.NO_POSITION
    }

    override fun onBindHeaderViewHolder(holder: RecyclerView.ViewHolder, headerPosition: Int) {
        val header = totalList[headerPosition] as DataItem.Header
        (holder as HeaderViewHolder).binding.tvHeader.text = header.text
    }

    override fun onCreateHeaderViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        return HeaderViewHolder(HeaderRowBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }
}
 */