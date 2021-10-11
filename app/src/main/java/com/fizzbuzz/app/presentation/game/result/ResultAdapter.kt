package com.fizzbuzz.app.presentation.game.result

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fizzbuzz.app.commun.transform
import com.fizzbuzz.app.data.model.FizzBuzz
import com.fizzbuzz.app.databinding.ItemResultBinding

class ResultAdapter(
    private val fizzBuzz: FizzBuzz
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder = ItemViewHolder.from(parent)

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ItemViewHolder) {
            holder.bind(fizzBuzz.transform(position + 1))
        }
    }

    override fun getItemCount(): Int = fizzBuzz.limit


    internal class ItemViewHolder(private val binding: ItemResultBinding) : RecyclerView.ViewHolder(binding.root) {

        companion object {
            fun from(parent: ViewGroup): RecyclerView.ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemResultBinding.inflate(layoutInflater, parent, false)
                return ItemViewHolder(binding)
            }
        }

        fun bind(value: String) {
            binding.name.text = value
        }
    }
}