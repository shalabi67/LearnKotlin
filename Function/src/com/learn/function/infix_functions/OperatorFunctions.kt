package com.learn.function.infix_functions

/**
 * Created by mohammad on 10/31/2017.
 */
operator infix fun HtmlHeader.plus(other:HtmlHeader):HtmlHeader {
    return this add other;
}