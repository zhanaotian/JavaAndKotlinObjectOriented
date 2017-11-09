package com.jkwar.kotlin.staticstate;

import com.jkwar.kotlin.Overloads;
import java.util.ArrayList;
import java.util.List;


/**
 * 错误的方法重载
 */
public class Bug {
  public static void main(String[] args) {
    Overloads overloads = new Overloads();
    System.out.println(overloads.a());

    List<Integer> integerList = new ArrayList<>();
    integerList.add(1);
    integerList.add(3);
    integerList.add(2312);
    integerList.add(3213);
    integerList.add(312312);
    integerList.add(333);
    integerList.add(222);


    //删除
    integerList.remove(1);
    //remove(object) 原本是删除参数2312，但是由于bug，删除的是下标 2312 的数据
//    integerList.remove(2312);

  }
}
