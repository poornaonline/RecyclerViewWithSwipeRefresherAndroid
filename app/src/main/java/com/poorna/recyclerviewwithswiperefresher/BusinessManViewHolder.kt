package com.poorna.recyclerviewwithswiperefresher

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.poorna.recyclerviewwithswiperefresher.entity.BusinessMan
import kotlinx.android.synthetic.main.businessman_item.view.*

class BusinessManViewHolder constructor(itemView: View): RecyclerView.ViewHolder(itemView) {

    val firstNameTextView: TextView = itemView.firstNameTextView
    val lastNameTextView: TextView = itemView.lastNameTextView
    val ageTextView: TextView = itemView.ageTextView
    val imageView: ImageView = itemView.imageView

    fun bind(businessMan: BusinessMan) {
        firstNameTextView.setText(businessMan.firstName)
        lastNameTextView.setText(businessMan.lastName)
        ageTextView.setText(businessMan.age.toString())

        val requestOption = RequestOptions()
            .placeholder(R.drawable.ic_launcher_background)
            .error(R.drawable.ic_launcher_background)

        Glide.with(itemView.context).load(businessMan.imageUrl!!).into(imageView)
    }
}