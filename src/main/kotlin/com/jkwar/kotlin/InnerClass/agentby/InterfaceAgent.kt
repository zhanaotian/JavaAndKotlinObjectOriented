package com.jkwar.kotlin.InnerClass.agentby


/**
 * 接口代理
 */

//插入装置
interface Device {
    fun input()
}

//读取
interface Reader {
    fun read()
}

//写入
interface Write {
    fun write()
}

//蓝牙写入
class BleWrite : Write {
    override fun write() {
        println("蓝牙写入")
    }
}

//蓝牙读取
class BleRead : Reader {
    override fun read() {
        println("蓝牙读取")
    }

}

/**
 * 接口代理
 */
class DeiceRealization(private val reader: Reader, private val write: Write) : Device, Reader by reader, Write by write {
    override fun input() {
        println("reader is $reader  write is $write")
    }

    override fun read() {
        reader.read()
    }

    override fun write() {
        write.write()
    }
}


fun main(args: Array<String>) {
    val deice = DeiceRealization(BleRead(), BleWrite())
    deice.input()
    deice.write()
    deice.read()
}
