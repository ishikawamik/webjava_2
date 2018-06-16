package jp.co.systena.tigerscase.SpringHelloSystena.model;

public class Beef extends Food {
  @Override
  public String getName() {
    return "牛";
  }

  @Override
  public int getPrice() {
    return 600;
  }
}
