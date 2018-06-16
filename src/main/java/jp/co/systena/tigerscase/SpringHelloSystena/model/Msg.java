package jp.co.systena.tigerscase.SpringHelloSystena.model;

public class Msg {
  private Message message;
  private int num;

  public Msg(Message message, int num) {
    setMessage(message);
    setNum(num);
  }

  public Message getMessage() {
    return this.message;
  }
  public void setMessage(Message message) {
    this.message = message;
  }

  public void setNum(int num) {
    this.num = num;
  }
  public int getNum() {
    return this.num;
  }

  public int getSubtotalPurchasePrice() {
    return message.getPrice() * num;
  }

  public int getSubtotalPurchaseSpeed() {
    return message.getSpeed() * num;
  }

}