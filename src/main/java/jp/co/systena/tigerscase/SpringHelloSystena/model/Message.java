package jp.co.systena.tigerscase.SpringHelloSystena.model;

public class Message {
  //食べる速さ、お客の選択による
  private int speed;
  //メニュー、コックの選択による
  private String menu;
  //値段、食べ物の選択による
  private int price;

  public Message (int speed, String menu, int price) {
      setSpeed(speed);
      setMenu(menu);
      setPrice(price);
  }

  public int getSpeed() {
    return this.speed;
  }
  public void setSpeed(int speed) {
    this.speed = speed;
  }

  public String getMenu() {
    return this.menu;
  }
  public void setMenu(String menu) {
    this.menu = menu;
  }

  public int getPrice() {
    return this.price;
  }
  public void setPrice(int price) {
    this.price = price;
  }

}