package com.windhike.kotlinlearn

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import com.windhike.kotlinlearn.extensions.ctx
import com.windhike.kotlinlearn.model.ForecastList
import com.windhike.kotlinlearn.model.ModelForecast
import org.jetbrains.anko.find

/**
 * author: gzzyj on 2017/1/17.
 * email:zhyongjun@windhike.cn
 */
class TextListAdapter(val list:ForecastList,val itemClickListener: (View) -> Unit) : RecyclerView.Adapter<TextListAdapter.Holder>(){

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): TextListAdapter.Holder {
        return Holder(LayoutInflater.from(parent?.context).inflate(R.layout.item_forecast,parent,false),itemClickListener)
    }

    override fun onBindViewHolder(holder: TextListAdapter.Holder?, position: Int) {
        holder?.bindForecast(list[position])
    }

    override fun getItemCount(): Int = list.size()

    class Holder(view: View,val itemClickListener: (View) -> Unit) :RecyclerView.ViewHolder(view){
        private val icons:ImageView
        private val tvDate:TextView
        private val tvDescription:TextView
        private val tvMaxTemperature:TextView
        private val tvMinTemperature:TextView
        init {
            icons= view.find(R.id.icon)
            tvDate = view.find(R.id.date)
            tvDescription = view.find(R.id.description)
            tvMaxTemperature = view.find(R.id.maxTemperature)
            tvMinTemperature = view.find(R.id.minTemperature)
        }

        fun bindForecast(forecast: ModelForecast) {
            with(forecast) {
                Picasso.with(itemView.ctx).load(iconUrl).into(icons)
                tvDate.text = "$date"
                tvDescription.text = "$description"
                tvMaxTemperature.text = "$high"
                tvMinTemperature.text = "$low"
                itemView.setOnClickListener { itemClickListener(itemView)}
            }
        }
    }
}

