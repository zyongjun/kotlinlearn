package com.windhike.kotlinlearn

import com.windhike.kotlinlearn.model.ModelForecast

/**
 * author: gzzyj on 2017/1/24.
 * email:zhyongjun@windhike.cn
 */
interface OnItemClickListener {
    operator fun invoke(forecast:ModelForecast)
}