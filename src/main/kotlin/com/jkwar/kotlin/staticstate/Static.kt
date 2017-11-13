package com.jkwar.kotlin


fun main(args: Array<String>) {
    val latityde = Latitud.ofDoudle(3.0)
    val latityde1 = Latitud.ofLatitud(latityde)

    val static = Static()
    println(static.sum())
    println(static.sum(1))
    println(static.sum(2,3))
//    println(latityde.TAG)
//    println(latityde.value)
//    println(latityde1.value)

    /**
     * arraylist.remove(int index)
     * 改为 removeAt(int index)
     */
//    val integerList = ArrayList<Int>()
//    integerList.add(13)
//    integerList.add(2)
//    integerList.add(3)
//    integerList.add(23)
//    integerList.add(5)
//    integerList.add(15)
//    integerList.add(50)
//    integerList.add(500)
//    println(integerList)
//
//    integerList.removeAt(1)
//    integerList.remove(5)
//    println(integerList)

}


class Static {
     fun sum(int: Int = 0): Int {
        return int
    }

    fun sum(): Int {
        return 0
    }

    fun sum(a: Int, b: Int): Int {
        return a + b
    }
}


/**
 * 伴生对象 静态成员
 */
class Latitud private constructor(val value: Double) {
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


