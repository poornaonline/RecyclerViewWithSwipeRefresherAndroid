package com.poorna.recyclerviewwithswiperefresher

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.poorna.recyclerviewwithswiperefresher.entity.BusinessMan

class BusinessMenRecyclerViewAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var businessMen = ArrayList<BusinessMan>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return BusinessManViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.businessman_item, parent, false))
    }

    override fun getItemCount(): Int {
        return businessMen.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder) {
            is BusinessManViewHolder -> {
                holder.bind(businessMen.get(position))
            }
        }
    }

    fun populateBusinessMen(businessMen: ArrayList<BusinessMan>) {
        this.businessMen = businessMen
    }
}