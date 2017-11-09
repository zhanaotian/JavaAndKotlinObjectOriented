package com.jkwar.kotlin.InnerClass


open class InnerClassKotlin {
    val aInt: Int = 10

    /**
     * kotlin 内部类 默认是静态内部类
     */
    class Inner {
        fun hello() {
            println("静态内部类")
        }
    }

    inner class InnerNo {
        private val aInt: Int = 5
        fun hello() {
            println("非静态内部类" + this@InnerClassKotlin.aInt)
            //内部类成员
            println("非静态内部类" + aInt)
        }
    }
}

interface OnClickListener {
    fun onClick()
}

class View {
    var onClickListener: OnClickListener? = null
}


fun main(args: Array<String>) {
    val innerNo = InnerClassKotlin().InnerNo()
    innerNo.hello()
    val inner = InnerClassKotlin.Inner()
    inner.hello()
    val view = View()
    //匿名内部类 object :  //可以继承类，编译时有InnerClassKotlinKt$main$1 id
    view.onClickListener = object : InnerClassKotlin(), OnClickListener {
        override fun onClick() {
        }
    }
}