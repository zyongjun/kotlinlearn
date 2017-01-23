package com.windhike.kotlinlearn.domain.wrapper

import com.windhike.kotlinlearn.domain.model.ForecastList
import com.windhike.kotlinlearn.model.ForecastResult
import java.text.DateFormat
import java.util.*


/**
 * author: zyongjun on 2017/1/24 0024.
 * email: zhyongjun@windhike.cn
 */

public class ForecastDataMapper {
    fun convertFromDataModel(forecast: ForecastResult): ForecastList {
        return ForecastList(forecast.city.name, forecast.city.country,
                convertForecastListToDomain(forecast.list))
        private fun convertForecastListToDomain(list: List<com.windhike.kotlinlearn.domain.model.Forecast>):
                List<ModelForecast> {
            return list.map { convertForecastItemToDomain(it) }
        }
        private fun convertForecastItemToDomain(forecast: Forecast): ModelForecast {
            return ModelForecast(convertDate(forecast.dt),
                    forecast.weather[0].description, forecast.temp.max.toInt(),
                    forecast.temp.min.toInt())
        }
        private fun convertDate(date: Long): String {
            val df = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.getDefault())
            return df.format(date * 1000)
        }
    }
