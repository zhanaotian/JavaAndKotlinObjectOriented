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
enum class Colors {
       BLACK {
        override fun signal(): Colors {
            return this
        }
    },


    WRITE {
        override fun signal(): Colors {
            return BLACK
        }
    };

    abstract fun signal(): Colors
}


fun main(args: Array<String>) {
    println(Direction.EAST)
    println(LogLevel.DEBUG.ordinal)
    //遍历LogLevel
    LogLevel.values().map(::println)
    //查找
    println(LogLevel.valueOf("ERROR".toUpperCase()))
    //匿名类
    println(Colors.WRITE.signal())

    println(enumValues<LogLevel>().joinToString { it.name })
    println(enumValueOf<LogLevel>("ERROR"))
}

/**
 * 手动实现emum
 */
class LogLevel2 private constructor() {
    companion object {
        val VERBOSE = LogLevel2()
        val DEBUG = LogLevel2()
        val INFO = LogLevel2()
        val WARN = LogLevel2()
        val ERROR = LogLevel2()
        val ASSERT = LogLevel2()
    }
}