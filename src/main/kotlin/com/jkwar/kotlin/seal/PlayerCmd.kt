package com.jkwar.kotlin.seal



/**
 * 密封类的一个子类可以有可包含状态的多个实例
 * 所有子类都必须在与密封类自身相同的文件中声明（在 Kotlin 1.1 之前， 该规则更加严格：子类必须嵌套在密封类声明的内部）
 * 适用于指令方式
 */
sealed class PlayerCmd {
    class Play(val url: String, val position: Long = 0) : PlayerCmd()

    class Seek(val position: Long) : PlayerCmd()

    object Pause : PlayerCmd()

    object Resume : PlayerCmd()

    object Stop : PlayerCmd()
}

/**
 * 每个枚举常量只存在一个实例
 * 适用于状态，不需要参数
 */
enum class PlayerState {
    PAUSE, PLAYING, IDLE
}

data class Const(val number: Double) : PlayerCmd()

data class Sum(val e1: PlayerCmd, val e2: PlayerCmd) : PlayerCmd()

fun main(args: Array<String>) {
    println(Const(2.00).number)
    println(Sum(Const(20.0), Const(30.0)))
}

