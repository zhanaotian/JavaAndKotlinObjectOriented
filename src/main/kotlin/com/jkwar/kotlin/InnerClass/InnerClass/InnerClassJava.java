package com.jkwar.kotlin.InnerClass.InnerClass;

import com.jkwar.kotlin.InnerClass.OnClickListener;
import com.jkwar.kotlin.InnerClass.View;

/**
 * 内部类 静态内部类
 */
public class InnerClassJava {

  public int anInt = 20;


  /**
   * 非静态内部类 持有外部类的状态
   */
  public class InnerNo {

    public void hello() {
      System.out.println("非静态内部类" + anInt);
    }
  }

  /**
   * 静态内部类 没有持有
   */
  public static class Inner {

    public void hello() {
      System.out.println("静态内部类");
    }
  }


  public static void main(String[] args) {
    InnerClassJava javaInternalClass = new InnerClassJava();
    InnerNo internalNo = javaInternalClass.new InnerNo();
    internalNo.hello();
    Inner internal = new Inner();
    internal.hello();
    View view = new View();
    //匿名内部类 ()
    view.setOnClickListener(() -> {

    });
  }
}
