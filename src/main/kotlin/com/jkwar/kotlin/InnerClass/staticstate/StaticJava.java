package com.jkwar.kotlin.InnerClass.staticstate;

import com.jkwar.kotlin.Latitud;

public class StaticJava {

  public static void main(String[] args) {
    Latitud latitud = Latitud.Companion.ofDoudle(2.0);
    Latitud latitud2 = Latitud.ofDoudle(2.0);
    System.out.println(latitud.getValue());
    System.out.println(latitud2.TAG);
  }
}
