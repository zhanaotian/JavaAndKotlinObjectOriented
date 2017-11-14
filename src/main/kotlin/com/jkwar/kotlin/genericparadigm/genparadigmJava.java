package com.jkwar.kotlin.genericparadigm;

import java.util.ArrayList;
import java.util.List;

/**
 * java 泛型
 */
class genParadigmJava {
  public static void main(String[] args) {
    //泛型是不支持协变,编译错误
    //List<Object> list = new ArrayList<String>();

    //协变
    //子类变量能赋给父类变量，父类变量不能赋值给子类变量。
    //要从泛型类取数据时，用extends；
    //协变->方法的返回值，对返回类型是协变的:Object -> String
    List<? extends Object> list = new ArrayList<String>();
    Object object = list.get(0);

    //逆变
    //将父类变量赋值给子类变量。
    //要往泛型类写数据时，用super
    // 逆变->方法的参数，对输入类型是逆变的:String -> Object
    List<? super String> list1 = new ArrayList<Object>();
    list1.add("112");
  }
}