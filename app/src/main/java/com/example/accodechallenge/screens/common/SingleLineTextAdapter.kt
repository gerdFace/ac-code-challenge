package com.example.accodechallenge.screens.common

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.accodechallenge.databinding.SingleLineTextItemViewBinding

class SingleLineTextAdapter : RecyclerView.Adapter<SingleLineTextViewHolder>() {

    private var textItems: MutableList<String> = ArrayList()

    fun setTextItems(textItems: List<String>) {
        this.textItems = textItems.toMutableList()
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = textItems.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SingleLineTextViewHolder =
        SingleLineTextViewHolder(
            SingleLineTextItemViewBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: SingleLineTextViewHolder, position: Int): Unit =
        holder.setData(textItems[position])
}