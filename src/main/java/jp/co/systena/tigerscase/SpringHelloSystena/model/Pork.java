package jp.co.systena.tigerscase.SpringHelloSystena.model;

public class Pork extends Food {
  @Override
  public String getName() {
    return "豚";
  }

  @Override
  public int getPrice() {
    return 300;
  }
}
