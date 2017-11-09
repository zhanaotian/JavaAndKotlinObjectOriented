package com.jkwar.kotlin.expand


fun main(args: Array<String>) {
    println("aaaaaaaa" * 10)

    val list = arrayListOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    println(list)
    list.swap(0, 3)
    println(list)
    printFoo(D())

    println("可空的接收者" + null.toString())

    println("伴生对象")
    C.foo()

    B().caller(A1()) //扩展接收者静态解析
    B1().caller(A())  // 分发接收者静态解析
}


/**
 * 调用的扩展函数只取决于所在表达式的类型
 * 如果类定义成员函数和扩展函数，并且又有相同的接受者类型，相同的名字、参数，那么优先去成员函数
 */
open class C {
    fun foo() {
        println("member")
    }

    companion object
}


class D : C()

fun C.foo() = "c"

fun D.foo() = "d"

fun printFoo(c: C) {
    println(c.foo())
}


/**
 * 可空的接受者
 */
fun Any?.toString(): String {
    if (this == null) return "null"
    return toString()
}


/**
 * 扩展属性
 */
val <T> List<T>.lastIndex: Int
    get() = size - 1


/**
 * 伴生对象的扩展
 */
fun C.Companion.foo() {
    println("伴生对象的扩展")
}


/**
 * 扩展成员
 */
open class A

class A1 : A()

open class B {
    open fun A.foo() {
        println("a.foo in b")
    }

    open fun A1.foo() {
        println("a1.foo in b")
    }

    fun caller(a: A) {
        a.foo()
    }
}


class B1 : B() {
    override fun A.foo() {
        println("a.foo in b1")
    }

    override fun A1.foo() {
        println("a1.foo in b1")
    }
}


/**
 * 扩展函数
 * 颠倒指定下标的值
 */
fun <T> MutableList<T>.swap(index1: Int, index2: Int) {
    val tmp = this[index1]
    this[index1] = this[index2]
    this[index2] = tmp
}

/**
 *  扩展函数
 *  字符叠加
 */
operator fun String.times(a: Int): String {
    val stringBuilder = StringBuilder()
    for (s in a until a) {
        stringBuilder.append(this)
    }
    return stringBuilder.toString()
}