package com.example.uznomhubai.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.uznomhubai.databinding.RecyclerViewObjectItemBinding
import com.example.uznomhubai.model.response.ResponceNameObjectData

class ObjectNameRecyclerViewAdapter: RecyclerView.Adapter<ObjectNameRecyclerViewAdapter.ViewHolder>() {

    private var dataList: List<ResponceNameObjectData> = emptyList()

    inner class ViewHolder(private val binding: RecyclerViewObjectItemBinding): RecyclerView.ViewHolder(binding.root){
        fun onBind(responceNameObjectData: ResponceNameObjectData) {
            with(binding) {
                itemNameTxt.text = responceNameObjectData.name
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = RecyclerViewObjectItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = dataList.count()

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(dataList[position])
    }

    fun submitList(dataList: List<ResponceNameObjectData>) {
        this.dataList = dataList
        notifyDataSetChanged()
    }

}