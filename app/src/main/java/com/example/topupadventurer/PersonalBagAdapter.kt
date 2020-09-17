package com.example.topupadventurer

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.topupadventurer.GameElement.GameItem
import com.example.topupadventurer.view.ItemDetailDialog

class PersonalBagAdapter(list:ArrayList<GameItem>):RecyclerView.Adapter<PersonalBagAdapter.ViewHolder>(){

    private val things:ArrayList<GameItem> = list
    private lateinit var context:Context

    class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        var imageView:ImageView=itemView.findViewById(R.id.iv_thing_bag)
        var textView:TextView=itemView.findViewById(R.id.tv_item_times)
        var view:View=itemView.findViewById(R.id.xml_rv_item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context=parent.context
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item,parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val theItem: GameItem =things[position]
        holder.imageView.setImageResource(theItem.itemImage)
        if (theItem.isShowTimes)
            holder.textView.text=""+theItem.itemTimes
        else
            holder.textView.text=""
        holder.view.setOnClickListener {
            ItemDetailDialog(context,theItem).show()
        }
    }

    override fun getItemCount(): Int {
        return things.size
    }
}