package com.windhike.kotlinlearn.domain.wrapper

import com.windhike.kotlinlearn.model.Forecast
import com.windhike.kotlinlearn.model.ForecastList
import com.windhike.kotlinlearn.model.ForecastResult
import com.windhike.kotlinlearn.model.ModelForecast
import java.text.DateFormat
import java.util.*


/**
 * author: zyongjun on 2017/1/24 0024.
 * email: zhyongjun@windhike.cn
 */

class ForecastDataMapper {
    fun convertFromDataModel(forecast: ForecastResult): ForecastList {
        return ForecastList(forecast.city.id,forecast.city.name, forecast.city.country,
                convertForecastListToDomain(forecast.list))
    }
    private fun convertForecastListToDomain(list: List<Forecast>):
            List<ModelForecast> {
        return list.map { convertForecastItemToDomain(it) }
    }
    private fun convertForecastItemToDomain(forecast: Forecast): ModelForecast {
        return ModelForecast(convertDate(forecast.dt),
                forecast.weather[0].description, forecast.temp.max.toInt(),
                forecast.temp.min.toInt(),generateUrl(forecast.weather[0].icon))
//        return forecast
    }
    private fun convertDate(date: Long): String {
        val df = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.getDefault())
        return df.format(date * 1000)
    }

    private fun generateUrl(icon: String): String = "http://openweathermap.org/img/w/$icon.png"
}
