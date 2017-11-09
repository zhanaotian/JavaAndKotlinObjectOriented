package com.jkwar.kotlin.enumeration

/**
 * 方向枚举
 */
enum class Direction {
    NORTH, SOUTH, WEST, EAST
}

//初始化
enum class LogLevel(val id: Int) {
    VERBOSE(0), DEBUG(1), INFO(2), WARN(3), ERROR(4), ASSERT(5);

    override fun toString(): String {
        return "$name $ordinal"
    }


}

//匿名类

fun main(args: Array<String>) {
    println(Direction.EAST)
    println(LogLevel.DEBUG.id)
}