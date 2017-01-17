package com.windhike.kotlinlearn

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.widget.TextView

/**
 * author: gzzyj on 2017/1/17.
 * email:zhyongjun@windhike.cn
 */
class TextListAdapter(val list:List<String>) : RecyclerView.Adapter<TextListAdapter.Holder>(){

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): TextListAdapter.Holder {
        return Holder(TextView(parent?.context))
    }

    override fun onBindViewHolder(holder: TextListAdapter.Holder?, position: Int) {
        holder?.view?.text = list[position]
    }

    override fun getItemCount(): Int = list.size

    class Holder(val view: TextView) :RecyclerView.ViewHolder(view)
}

