package jp.co.systena.tigerscase.SpringHelloSystena.model;

public class Elder implements Costomer {
  @Override
  public int eat() {
    return 10000;
  }

  public String name = "年配";

  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
}