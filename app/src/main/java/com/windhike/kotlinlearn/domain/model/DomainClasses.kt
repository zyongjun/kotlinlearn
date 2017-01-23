package com.windhike.kotlinlearn.domain.model

/**
 * author: zyongjun on 2017/1/24 0024.
 * email: zhyongjun@windhike.cn
 */
data class ForecastList(val id: Long, val city: String, val country: String, val dailyForecast: List<Forecast>) {
    operator fun get(position: Int) = dailyForecast[position]
    fun size() = dailyForecast.size
}

data class Forecast(val id: Long, val date: Long, val description: String, val high: Int, val low: Int,
                    val iconUrl: String)