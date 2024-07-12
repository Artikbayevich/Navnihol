package com.example.uznomhubai.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.uznomhubai.databinding.RecyclerViewItemBinding
import com.example.uznomhubai.model.response.ResponseData

class RecyclerViewAdapter: RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    private var dataList: List<ResponseData> = emptyList()

    inner class ViewHolder(private val binding: RecyclerViewItemBinding): RecyclerView.ViewHolder(binding.root){
        fun onBind(responseData: ResponseData) {
            with(binding) {
                itemNameTxt.text = responseData.name
                itemDetTxt.text = responseData.det
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = RecyclerViewItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = dataList.count()

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(dataList[position])
    }

    fun submitList(dataList: List<ResponseData>) {
        this.dataList = dataList
        notifyDataSetChanged()
    }

}