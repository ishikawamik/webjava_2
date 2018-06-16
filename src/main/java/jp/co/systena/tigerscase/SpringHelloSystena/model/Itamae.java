package jp.co.systena.tigerscase.SpringHelloSystena.model;

public class Itamae implements Cock {
  @Override
  public String cook() {
    return "寿司";
  }
  public String name = "板前";

  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
}