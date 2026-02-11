package com.ehdnd.spring_basic.singleton;

public class StatefulService {

  private int price; // 상태를 유지하는 필드

  void order(String name, int price) {
    System.out.println("name = " + name + ", price = " + price);
    this.price = price; // 여기가 문제!
  }

  int getPrice() {
    return price;
  }

}
