package com.learn.function.infix_functions

/**
 * Created by mohammad on 10/31/2017.
 */
infix fun HtmlHeader.add(other:HtmlHeader) : HtmlHeader {
    return HtmlHeader(this.name + other.name)
}