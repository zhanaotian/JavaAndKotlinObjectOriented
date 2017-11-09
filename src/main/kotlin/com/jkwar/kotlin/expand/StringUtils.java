package com.jkwar.kotlin.expand;

/**
 * java 工具类
 */
public class StringUtils {

  private static boolean isEmpty(String[] args) {
    return args.length == 0;
  }

  public static boolean isNotEmpty(String[] args) {
    return args.length > 0;
  }
}
