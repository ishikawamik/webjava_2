package jp.co.systena.tigerscase.SpringHelloSystena.model;

public class Salmon extends Food {
  @Override
  public String getName() {
    return "サーモン";
  }

  @Override
  public int getPrice() {
    return 1000;
  }
}
