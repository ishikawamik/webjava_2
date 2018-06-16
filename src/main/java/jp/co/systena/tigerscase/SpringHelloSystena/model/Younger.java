package jp.co.systena.tigerscase.SpringHelloSystena.model;

public class Younger implements Costomer {
  @Override
  public int eat() {
    return 5000;
  }

  public String name = "若い人";

  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
}