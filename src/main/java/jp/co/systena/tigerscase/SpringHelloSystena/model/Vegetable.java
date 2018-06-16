package jp.co.systena.tigerscase.SpringHelloSystena.model;

public class Vegetable extends Food {
  @Override
  public String getName() {
    return "野菜";
  }

  @Override
  public int getPrice() {
    return 500;
  }
}
