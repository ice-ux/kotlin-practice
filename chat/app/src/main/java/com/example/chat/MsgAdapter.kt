package com.example.chat

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MsgAdapter (val msgList :  List<Msg> ) : RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    inner class LeftViewHoldr(view :View):RecyclerView.ViewHolder(view){
        val leftMsg : TextView = view.findViewById(R.id.leftMsg)
    }
    inner class RightViewHoldr(view :View):RecyclerView.ViewHolder(view){
        val rightMsg : TextView = view.findViewById(R.id.rightMsg)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
    = if (viewType == Msg.TYPE_RECEIVED){
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.msg_left_item,parent,false)
        LeftViewHoldr(view)
    } else {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.msg_right_item,parent,false)
        RightViewHoldr(view)
    }

    override fun getItemViewType(position: Int): Int {
        val msg = msgList[position]
        return msg.type
    }

    override fun getItemCount(): Int {

        return msgList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        val msg = msgList[position]
        when(holder){
            is LeftViewHoldr -> holder.leftMsg.text = msg.content
            is RightViewHoldr -> holder.rightMsg.text = msg.content
            else -> throw IllegalArgumentException()
        }
    }
}