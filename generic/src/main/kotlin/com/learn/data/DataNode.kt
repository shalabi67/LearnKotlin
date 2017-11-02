package com.learn.data

/**
 * Created by mohammad on 11/2/2017.
 */
class DataNode<T:IData>(private val item:T) {
    fun getItem() : T {
        return item;
    }
}