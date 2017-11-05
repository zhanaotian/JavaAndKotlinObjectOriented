package com.jkwar.kotlin.inherit


/**
 * 普通经理
 */
class Manager : Driver, Writer {
    override fun drive() {
        println("开车")
    }

    override fun write() {
        println("写ppt总结")
    }
}

/**
 * 高级经理
 * 接口代理
 */
class SeniorManager(val driver: Driver, val writer: Writer) : Driver by driver, Writer by writer

/**
 * 高级经理
 * 普通实现
 */
class SeniorManager1(val driver: Driver, val writer: Writer) : Driver, Writer {
    override fun drive() {
    }

    override fun write() {
    }

}

/**
 * driver 实现类
 */
class CarDriver : Driver {
    override fun drive() {
        println("驾驶小轿车")
    }
}

/**
 *Writer 实现类
 */
class PPTWriter : Writer {
    override fun write() {
        println("PPT写手")
    }
}


/**
 * 驾驶接口
 */
interface Driver {
    fun drive()
}

/**
 * 读取接口
 */
interface Writer {
    fun write()
}

fun main(args: Array<String>) {
    val driver = CarDriver()
    val writer = PPTWriter()
    val seniorManager = SeniorManager(driver, writer)
    seniorManager.drive()
    seniorManager.write()
}