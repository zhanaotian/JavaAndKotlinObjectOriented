package com.jkwar.kotlin.genericparadigm;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * java 泛型
 */
public class genParadigmJava {

  public static void main(String[] args) {
    List<String> strs = new ArrayList<>();
    //编译不了
    //interface Collection<E> …… {
    //void addAll(Collection<? extends E> items);
    //}
    // 因为 ? extends E 表示此方法接受 E 或者 E 的 一些子类型对象的集合，而不只是 E 自身
    //List<Object> objs = strs;
    List<Object> objs = new ArrayList<>();
    objs.add(1);

    copyAll(objs, strs);
  }

  void add(List<String> list) {
    List<? extends Object> objects = list;
  }


  private static void copyAll(Collection<Object> to, Collection<String> from) {
    to.addAll(from);
  }
}
