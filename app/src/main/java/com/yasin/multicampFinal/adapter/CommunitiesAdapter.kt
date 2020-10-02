package com.yasin.multicampFinal.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.yasin.multicampFinal.R


import com.yasin.multicampFinal.data.model.Community
import kotlinx.android.synthetic.main.community_recycler_row.view.*

class CommunitiesAdapter(val communityList:MutableList<Community>,val onClick: (Community) -> Unit):RecyclerView.Adapter<CommunitiesViewHolder> (){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommunitiesViewHolder {
        var inflate= LayoutInflater.from(parent.context).inflate(R.layout.community_recycler_row,parent,false)
        return CommunitiesViewHolder(inflate)
    }

    override fun onBindViewHolder(holder: CommunitiesViewHolder, position: Int) {
        val community:Community=communityList[position]
        holder.bind(community,onClick)
    }

    override fun getItemCount(): Int {
        return communityList.size
    }
}

class CommunitiesViewHolder(view:View):RecyclerView.ViewHolder(view) {
    fun bind(community: Community,onClick: (Community)->Unit ){
        itemView.imageView.load(community.banner)

        itemView.setOnClickListener {
            onClick(community)
        }
    }
}
