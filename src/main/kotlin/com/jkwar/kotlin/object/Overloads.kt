package com.jkwar.kotlin

import java.util.*

class Overloads {

    @JvmOverloads
    fun a(x: Int = 0): Int {
        return x
    }

    fun a(x: String): Int {
        return x.length
    }
}

fun main(args: Array<String>) {
    val overloads = Overloads()
    println(overloads.a())
    println(overloads.a(12))
    println(overloads.a("哈哈哈"))


    /**
     * 正确的方法重载
     */
    val integerList = ArrayList<Int>()
    integerList.add(1)
    integerList.add(3)
    integerList.add(2312)
    integerList.add(3213)
    integerList.add(312312)
    integerList.add(333)
    integerList.add(222)


    //删除
    integerList.removeAt(1)
    //remove(object)
    integerList.remove(2312)
}