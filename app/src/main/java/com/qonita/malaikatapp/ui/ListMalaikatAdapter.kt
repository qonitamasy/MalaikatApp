package com.qonita.malaikatapp.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.qonita.malaikatapp.R
import com.qonita.malaikatapp.data.MalaikatData
import com.squareup.picasso.Picasso

class ListMalaikatAdapter(private val listmalaikat: ArrayList<MalaikatData>) :
    RecyclerView.Adapter<ListMalaikatAdapter.ListViewHolder>() {
    private lateinit var onItemClickCallback: OnItemCLickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemCLickCallback){
        this.onItemClickCallback = onItemClickCallback
    }



    inner class ListViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {
            var tvName: TextView = itemView.findViewById(R.id.tv_item_name)
            var tvDuty: TextView = itemView.findViewById(R.id.tv_item_duty)
            var imgPhoto: ImageView = itemView.findViewById(R.id.iv_item_photo)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ListViewHolder {
    val view: View = LayoutInflater.from(viewGroup.context)
        .inflate(R.layout.item_row_malaikat, viewGroup, false)
        return  ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
    val malaikat = listmalaikat[position]

        malaikat.photo?.let {
           Picasso.with(holder.itemView.context)
               .load(it)
               .resize(50, 50)
               .into(holder.imgPhoto)
        }

        holder.tvName.text = malaikat.name
        holder.tvDuty.text = malaikat.duty
        holder.itemView.setOnClickListener { onItemClickCallback.onItemClickedData(listmalaikat[holder.adapterPosition]) }
    }

    override fun getItemCount(): Int {
        return listmalaikat.size
    }

    interface OnItemCLickCallback {
        fun onItemClickedData(data: MalaikatData)
    }
}


