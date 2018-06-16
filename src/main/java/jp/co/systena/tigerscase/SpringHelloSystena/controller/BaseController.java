package jp.co.systena.tigerscase.SpringHelloSystena.controller;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import jp.co.systena.tigerscase.SpringHelloSystena.model.Cart;
import jp.co.systena.tigerscase.SpringHelloSystena.model.Purchase;

public class BaseController {
    @Autowired
    private HttpSession session;

    private final String KEY_SESSION_MESSAGE = "message";
    private final String KEY_SESSION_CART    = "cart";
    private final String KEY_SESSION_TEST    = "test";
    private final String KEY_SESSION_SPEED   = "speed";
    private final String KEY_SESSION_COOKING = "cooking";
    private final String KEY_SESSION_FOOD    = "food";
    private final String KEY_SESSION_FOODPRICE = "foodprice";
    private final String KEY_SESSION_PURCHASE    = "cpurchase";

    protected Cart getCartFromSession() {
        Cart cart = (Cart)session.getAttribute(KEY_SESSION_CART);
        if(cart == null) {
            cart = new Cart();
            setCartFromSession(cart);
        }
        return cart;
    }

    protected void setCartFromSession(Cart cart) {
        session.setAttribute(KEY_SESSION_CART, cart);
    }

    protected String getMessageFromSession() {
        return (String) session.getAttribute(KEY_SESSION_MESSAGE);
    }

    protected void setMessageFromSession(String message) {
        session.setAttribute(KEY_SESSION_MESSAGE, message);
    }

    protected void removeMessageFromSession() {
        session.removeAttribute(KEY_SESSION_MESSAGE);
    }

    protected String getTestFromSession() {
      return (String) session.getAttribute(KEY_SESSION_TEST);
    }

    protected void setTestFromSession(String test) {
      session.setAttribute(KEY_SESSION_TEST, test);
    }

    protected void removeTestFromSession() {
      session.removeAttribute(KEY_SESSION_TEST);
  }
    protected String getSpeedFromSession() {
      return (String) session.getAttribute(KEY_SESSION_SPEED);
    }

    protected void setSpeedFromSession(String speed) {
      session.setAttribute(KEY_SESSION_SPEED, speed);
    }

    protected void removeSpeedFromSession() {
      session.removeAttribute(KEY_SESSION_SPEED);
  }

    public String getCookingFromSession() {
      return (String) session.getAttribute(KEY_SESSION_COOKING);
    }

    protected void setCookingFromSession(String cooking) {
      session.setAttribute(KEY_SESSION_COOKING, cooking);
    }

    protected void removeCookingFromSession() {
      session.removeAttribute(KEY_SESSION_COOKING);
    }

    public String getFoodFromSession() {
      return (String) session.getAttribute(KEY_SESSION_FOOD);
    }

    protected void setFoodFromSession(String food) {
      session.setAttribute(KEY_SESSION_FOOD, food);
    }

    protected void removeFoodFromSession() {
      session.removeAttribute(KEY_SESSION_FOOD);
  }

    public String getFoodPriceFromSession() {
      return (String) session.getAttribute(KEY_SESSION_FOODPRICE);
    }

    protected void setFoodPriceFromSession(String foodprice) {
      session.setAttribute(KEY_SESSION_FOODPRICE, foodprice);
    }

    protected void removeFoodPriceFromSession() {
      session.removeAttribute(KEY_SESSION_FOODPRICE);
  }

    protected Purchase getPurchaseFromSession() {
      Purchase purchase = (Purchase)session.getAttribute(KEY_SESSION_PURCHASE);
      if(purchase == null) {
          purchase = new Purchase();
          setPurchaseFromSession(purchase);
      }
      return purchase;
  }

  protected void setPurchaseFromSession(Purchase purchase) {
      session.setAttribute(KEY_SESSION_PURCHASE, purchase);
  }

}
