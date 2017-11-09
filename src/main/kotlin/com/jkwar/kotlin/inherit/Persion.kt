package com.jkwar.kotlin.inherit

/**
 * @property Persion 弗雷
 * @param age 年龄
 * 抽象类决定你是什么
 */
abstract class Persion(open val age: Int) {
    abstract fun work()
}

/**
 * @property other
 * 接口决定功能
 */
interface other {
    fun readBook()
}


/**
 * 码农
 */
class MaNong(age: Int) : Persion(age), other {
    override fun readBook() {
        println("码农读数学书")
    }

    override fun work() {
        println("码农正在敲代码")
    }

    fun rest() {
        println("码农已经休息了")
    }
}


/**
 * 医生
 */
class YiSheng(age: Int) : Persion(age), other {
    override fun readBook() {
        println("医生读医学书")
    }

    override fun work() {
        println("医生正在给病人治病")
    }

}


fun main(args: Array<String>) {
    val person: Persion = MaNong(25)
    person.work()
    val person2 = YiSheng(35)
    person2.work()
    person2.readBook()
}