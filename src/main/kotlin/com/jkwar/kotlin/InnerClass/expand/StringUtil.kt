package com.jkwar.kotlin.InnerClass.expand


fun main(args: Array<String>) {
    println("aaaaaaaa" * 10)
}


/**
 *
 */
operator fun String.times(a: Int): String {
    val stringBuilder = StringBuilder()
    for (s in a until a) {
        stringBuilder.append(this)
    }
    return stringBuilder.toString()
}