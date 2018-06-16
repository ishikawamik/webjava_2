package jp.co.systena.tigerscase.SpringHelloSystena.model;

import java.util.List;
import org.springframework.web.servlet.ModelAndView;

public class CartView extends ModelAndView {
    private String ATTRIBUTE_NAME_MESSAGE     = "message";
    private String ATTRIBUTE_NAME_CART_CART   = "cart";
    private String ATTRIBUTE_NAME_TOTAL_PRICE = "totalPrice";
    private String ATTRIBUTE_NAME_CART_FORM   = "cartForm";

    private String ATTRIBUTE_NAME_TOTALPURCHASEPRICE = "totalPurchasePrice";
    private String ATTRIBUTE_NAME_TOTALPURCHASESPEED = "totalPurchaseSpeed";

    private String VIEW_NAME = "cart";

    public CartView(String message, Cart cart, CartForm cartForm,
        int totalPurchasePrice, int totalPurchaseSpeed, List<Purchase> purchaseList,
        Purchase purchase) {
        this.addObject(ATTRIBUTE_NAME_MESSAGE, message);
        this.addObject(ATTRIBUTE_NAME_CART_CART, cart);
        this.addObject(ATTRIBUTE_NAME_TOTAL_PRICE, cart.getTotalPrice());
        this.addObject(ATTRIBUTE_NAME_CART_FORM, cartForm);

        StringBuilder purchasePriceBuf = new StringBuilder();
        purchasePriceBuf.append("合計金額：");
        purchasePriceBuf.append(totalPurchasePrice);
        purchasePriceBuf.append(" 円");
        this.addObject(ATTRIBUTE_NAME_TOTALPURCHASEPRICE, purchasePriceBuf.toString());

        StringBuilder purchaseSpeedBuf = new StringBuilder();
        purchaseSpeedBuf.append("滞在時間：");
        purchaseSpeedBuf.append(totalPurchaseSpeed);
        purchaseSpeedBuf.append(" 秒");
        this.addObject(ATTRIBUTE_NAME_TOTALPURCHASESPEED, purchaseSpeedBuf.toString());

        this.addObject("purchaseList", purchaseList);
        this.addObject("purchase", purchase);

        this.setViewName(VIEW_NAME);
    }
}
