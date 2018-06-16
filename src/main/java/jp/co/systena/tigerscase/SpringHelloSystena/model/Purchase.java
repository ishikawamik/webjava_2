package jp.co.systena.tigerscase.SpringHelloSystena.model;

import java.util.ArrayList;
import java.util.List;

public class Purchase {
  private List<Msg> purchaseList = new ArrayList<Msg>();

  public List<Msg> getPurchaseList(){
    return this.purchaseList;
  }
  public void setPurchaseList(List<Msg> purchaseList) {
    this.purchaseList = purchaseList;
  }

  public int getpurchaseNum() {
    int purchaseNum = 0;

    for(Msg msg : purchaseList) {
      purchaseNum += msg.getNum();
    }
    return purchaseNum;
  }

  public int getTotalPurchasePrice() {
    int totalPurchasePrice = 0;

    for(Msg msg : purchaseList) {
      totalPurchasePrice += msg.getSubtotalPurchasePrice();
    }
    return totalPurchasePrice;
  }
  public int getTotalPurchaseSpeed() {
    int totalPurchaseSpeed = 0;

    for(Msg msg : purchaseList) {
      totalPurchaseSpeed += msg.getSubtotalPurchaseSpeed();
    }
    return totalPurchaseSpeed;
  }

  public void addNum(Msg msg) {
    Msg currentMsg = findMsgByMessageSpeed(msg.getMessage().getSpeed());
    if(currentMsg == null) {
      purchaseList.add(msg);
    } else {
      currentMsg.setNum(currentMsg.getNum() + 1);
    }
  }

  public Msg findMsgByMessageSpeed(int messagespeed) {
    for(Msg msg : purchaseList) {
      if(msg.getMessage().getSpeed() == messagespeed) {
        return msg;
      }
    }
    return null;
  }


}