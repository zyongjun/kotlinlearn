package com.windhike.kotlinlearn.model

/**
 * author: zyongjun on 2017/1/24 0024.
 * email: zhyongjun@windhike.cn
 */
data class ForecastResult(val city: City, val list: List<Forecast>)
data class City(val id: Long, val name: String, val coord: Coordinates,
                val country: String, val population: Int)
data class Coordinates(val lon: Float, val lat: Float)
data class Forecast(val dt: Long, val temp: Temperature, val pressure: Float,
                    val humidity: Int, val weather: List<Weather>,
                    val speed: Float, val deg: Int, val clouds: Int,
                    val rain: Float)
data class Temperature(val day: Float, val min: Float, val max: Float,
                       val night: Float, val eve: Float, val morn: Float)
data class Weather(val id: Long, val main: String, val description: String,
                   val icon: String)

data class ForecastList(val id: Long, val city: String, val country: String, val dailyForecast: List<ModelForecast>) {
    operator fun get(position: Int) = dailyForecast[position]
    fun size() = dailyForecast.size
}

data class ModelForecast(val date: String, val description: String, val high: Int, val low: Int,
                    val iconUrl: String)