package com.jkwar.kotlin.interfaceandabstract;


public class PersionDemo {

  public static void main(String[] args) {
    MaNong maNong = new MaNong();
    maNong.work();
    YiSheng yiSheng = new YiSheng();
    yiSheng.work();
  }
}

abstract class Pension {
  abstract void work();
}


class MaNong extends Pension {

  @Override
  public void work() {
    System.out.println("码农正在敲代码");
  }
}

class YiSheng extends Pension {

  @Override
  public void work() {
    System.out.println("医生正在给病人治病");

  }
}
