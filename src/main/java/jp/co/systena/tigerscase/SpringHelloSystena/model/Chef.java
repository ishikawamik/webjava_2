package jp.co.systena.tigerscase.SpringHelloSystena.model;

public class Chef implements Cock {
  @Override
  public String cook() {
    return "オードブル";
  }

  public String name = "シェフ";

  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
}