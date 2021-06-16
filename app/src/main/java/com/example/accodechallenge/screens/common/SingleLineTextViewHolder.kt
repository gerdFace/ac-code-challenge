package com.example.accodechallenge.screens.common

import androidx.recyclerview.widget.RecyclerView
import com.example.accodechallenge.databinding.SingleLineTextItemViewBinding

class SingleLineTextViewHolder(bindingView: SingleLineTextItemViewBinding) : RecyclerView.ViewHolder(bindingView.root) {

    private val binding: SingleLineTextItemViewBinding = bindingView

    fun setData(itemText: String) {
        binding.tvItemText.text = itemText
    }
}