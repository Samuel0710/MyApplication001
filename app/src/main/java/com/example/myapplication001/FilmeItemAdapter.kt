package com.example.myapplication001

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication001.databinding.FilmeListItemBinding
import com.example.myapplication001.model.Film

class FilmeItemAdapter: ListAdapter <Film,FilmeItemAdapter.FilmeItemViewHolder > (DIFF_CALLBACK){

    var onClickListener:((filmID: Int) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmeItemViewHolder {
       val binding = FilmeListItemBinding.inflate(
           LayoutInflater.from(parent.context),parent,false)
        return FilmeItemViewHolder(binding, onClickListener)
    }

    override fun onBindViewHolder(holder: FilmeItemViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
    class FilmeItemViewHolder(
        private val binding: FilmeListItemBinding,
        private val onClickListener: ((filmID: Int) -> Unit)?
        ): RecyclerView.ViewHolder(binding.root){

            fun bind(film: Film ){
                binding.batmanTitle.text = film.original_title
                binding.resumeSinopse.text= film.title
                binding.batmanNota.text= film.poster_path

                binding.root.setOnClickListener {
                    onClickListener?.invoke(film.id)
                }

            }

    }
    companion object{
        private val DIFF_CALLBACK= object : DiffUtil.ItemCallback<Film>(){
            override fun areItemsTheSame(oldItem: Film, newItem: Film): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Film, newItem: Film): Boolean {
                return oldItem == newItem
            }
        }
        }


}