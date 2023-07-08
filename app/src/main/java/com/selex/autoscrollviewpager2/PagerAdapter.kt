package com.selex.autoscrollviewpager2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide

class PagerAdapter: RecyclerView.Adapter<PagerAdapter.PagerViewHolder>() {
    var listBanner = mutableListOf<Banner>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagerViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return PagerViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listBanner.size
    }

    override fun onBindViewHolder(holder: PagerViewHolder, position: Int) {
        holder.bind(listBanner[position])
    }

    class PagerViewHolder(itemView: View): ViewHolder(itemView) {
        val img: ImageView = itemView.findViewById(R.id.img)
        fun bind(data: Banner) {
            Glide.with(itemView).load(data.banner).error(R.drawable.naruto1).into(img)

        }
    }


}