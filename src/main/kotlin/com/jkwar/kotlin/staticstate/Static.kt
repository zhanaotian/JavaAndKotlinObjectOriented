package com.jkwar.kotlin

/**
 * 伴生对象 静态成员
 */
fun main(args: Array<String>) {
    val latityde = Latitud.ofDoudle(3.0)
    val latityde1 = Latitud.ofLatitud(latityde)

    println(latityde.TAG)
    println(latityde.value)
    println(latityde1.value)
}

class Latitud private constructor(val value: Double) {
    //伴生对象
    companion object {
        @JvmStatic
        fun ofDoudle(double: Double): Latitud {
            return Latitud(double)
        }

        //复制
        fun ofLatitud(latitud: Latitud): Latitud {
            return Latitud(latitud.value)
        }
    }

    @JvmField
    val TAG: String = "Latitud"
}