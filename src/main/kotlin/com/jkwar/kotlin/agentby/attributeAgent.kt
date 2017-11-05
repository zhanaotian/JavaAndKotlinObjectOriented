package com.jkwar.kotlin.agentby

import kotlin.properties.Delegates
import kotlin.reflect.KProperty


/**
 * 属性委托
 * b 傀儡
 * Delegate 实际操作对象
 */

//延迟属性（lazy properties）: 其值只在首次访问时计算，
//可观察属性（observable properties）: 监听器会收到有关此属性变更的通知，
//把多个属性储存在一个映射（map）中，而不是每个存在单独的字段中。
//局部委托属性
class Examle {
    val a by lazy(LazyThreadSafetyMode.PUBLICATION) {
        "哈哈哈"
    }
    val b by Delegate()

    var c by Delegate()

    var name: String by Delegates.observable("init") { _, oldValue, newValue ->
        println("$oldValue -> $newValue")
    }

    var age: String by Delegates.vetoable("init") { _, oldValue, newValue ->
        println("$oldValue -> $newValue")
        oldValue.length > newValue.length
    }
}



/**
 * 重写 setvalue getvalue 实现委托
 */
class Delegate {
    private var value: String = ""

    operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
        println("getVale $thisRef -> ${property.name}")
        return value
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
        println("getVale $thisRef -> ${property.name} = $value")
        this.value = value
    }
}

//构造函数接受一个映射参数
class User(val map: MutableMap<String, Any?>) {
    val name: String by map
    var age: String by map
}


fun main(args: Array<String>) {
    println(Examle().a)
    println(Examle().b)
    println(Examle().c)
    val examle = Examle()
    examle.c = "辅助"
    println(examle.c)
    //观察属性
    examle.name = "first"
    examle.name = "second"
    examle.age = "hhhaaa"
    examle.age = "heehe"

    val user = User(mutableMapOf("name" to "java", "age" to "20"))
    //这个映射中取值
    println(user.name)
    println(user.age)
    user.age = "50"
    println(user.age)
}