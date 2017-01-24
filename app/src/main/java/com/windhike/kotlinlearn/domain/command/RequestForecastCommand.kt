package com.windhike.kotlinlearn.domain.command

import android.view.View
import com.windhike.kotlinlearn.OnItemClickListener
import com.windhike.kotlinlearn.domain.wrapper.ForecastDataMapper
import com.windhike.kotlinlearn.http.ForcastByZipcodeRequest
import com.windhike.kotlinlearn.model.ForecastList

/**
 * author: gzzyj on 2017/1/24.
 * email:zhyongjun@windhike.cn
 */
class RequestForecastCommand(val zipcode:String) :Command<ForecastList>{
    override fun excute(): ForecastList {
//        throw UnsupportedOperationException("not implemented") //To change body of created functions use File | Settings | File Templates.
        val request = ForcastByZipcodeRequest(zipcode)
        return ForecastDataMapper().convertFromDataModel(request.request())
    }

    public fun setO(itemclick: (View) -> Unit) {

    }

}