package com.jkwar.kotlin.interfaceandabstract


/**
 * 接口与抽象类
 * @create 2017年11月1日14:55:16
 */

/**
 * 定义鼠标插入接口
 * @property input
 */
interface InputDevice {
    val width: Int
        get() = 100

    var height: Double

    fun input(event: Any) = Unit

    fun speak() {
        println("宽度 $width")
        println("高度 $height")
    }
}

/**
 * 定义鼠标设置接口
 *
 */
interface OpticalMouse

/**
 * usb鼠标插入接口
 */
interface USBInputDevice : InputDevice


/**
 * 蓝牙鼠标插入接口
 */
interface BLEInputDevice : InputDevice

/**
 * 定义一个鼠标抽象类
 */
abstract class USBMouse(val name: String) : USBInputDevice, BLEInputDevice, OpticalMouse {
    override fun input(event: Any) {
        println("插入了 $event")
    }

    override fun speak() {
        //接口冲突
        super<USBInputDevice>.speak()
        super<BLEInputDevice>.speak()
    }

    override fun toString(): String {
        return "USBMouse(name='$name')"
    }
}

class LogitechMouse : USBMouse("罗技鼠标") {
    override var height: Double = 16.6
        get() = field
        set(value) {
            if (value > 16.6)
                field = value
        }

}

/**
 * 鼠标工程类
 * @property Computer
 *
 */
class Computer {
    fun addUSBInputDevice(inputDevice: USBInputDevice) {
        //插入输入设备
        println("添加一个usb插入设备: $inputDevice")
    }

    fun addBLEInputDevice(inputDevice: BLEInputDevice) {
        println("添加一个蓝牙插入设备: $inputDevice")
    }

    fun addInputDevice(inputDevice: InputDevice) = when (inputDevice) {
        is USBInputDevice -> {
            addUSBInputDevice(inputDevice)
        }
        is BLEInputDevice -> {
            addBLEInputDevice(inputDevice)
        }
        else -> {
            throw IllegalArgumentException("输入设备类型不支持")
        }
    }
}


fun main(args: Array<String>) {
    val computer = Computer()
    val mouse = LogitechMouse()
    mouse.speak()
    mouse.height = 20.0
    mouse.speak()
    computer.addInputDevice(mouse)
}