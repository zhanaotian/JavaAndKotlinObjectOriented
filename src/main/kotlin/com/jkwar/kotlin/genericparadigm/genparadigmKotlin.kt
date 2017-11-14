package com.jkwar.kotlin.genericparadigm


abstract class Person<out T> {
    abstract fun get(): T
    //只能被生产，不能消费。
    //abstract fun add(t: T);
}

class Man : Person<String>() {
    override fun get(): String {
        return "添加男人"
    }
}

abstract class Car<in T> {
    abstract fun add(t: T)
    //只能被消费，不能生产
    //abstract fun get():T
}

class Automobiling : Car<String>() {
    override fun add(t: String) {
        println("添加了$t")
    }
}

/**
 * 类型投影
 */
fun <T> copy(from: Array<out T>, to: Array<in T>) {
    for (i in from.indices) {
        to[i] = from[i]
    }
}

/**
 * 星投影
 */


/**
 * 泛型函数
 */
fun <T> singletonList(item: T): List<T> {
    val list = arrayListOf<T>()
    list.add(item)
    return list
}

fun <T> T.basicToString(): String {
    return this.toString()
}


fun main(args: Array<String>) {
    //协变 生产者 out
    val man: Person<Any> = Man()
    println(man.get())

    //逆变 消费者 in
    val automobiling = Automobiling()
    automobiling.add("兰博基尼")

    //类型投影
    val ines = arrayOf(1, 2, 3, 4, 5)
    val any = Array<Any>(3) { "" }
    copy(ines, any)

    println(singletonList(1))

}

