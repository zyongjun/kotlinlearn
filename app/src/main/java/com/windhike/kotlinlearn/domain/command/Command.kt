package com.windhike.kotlinlearn.domain.command

/**
 * author: zyongjun on 2017/1/24 0024.
 * email: zhyongjun@windhike.cn
 */
interface Command<T>{
    fun excute():T
}