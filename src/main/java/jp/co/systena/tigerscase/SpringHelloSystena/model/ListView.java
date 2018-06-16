package jp.co.systena.tigerscase.SpringHelloSystena.model;

import java.util.List;
import org.springframework.web.servlet.ModelAndView;

public class ListView extends ModelAndView {
    private String ATTRIBUTE_NAME_MESSAGE        = "message";
    private String ATTRIBUTE_NAME_CART_ITEM_NUM  = "cartItemNumMessage";
    private String ATTRIBUTE_NAME_ITEMS          = "items";
    private String ATTRIBUTE_NAME_LIST_FORM      = "listForm";
    private String testDisplay = "testDisplay";

    private String ATTRIBUTE_NAME_TEST = "test";
    private String ATTRIBUTE_NAME_PURCHASE_NUM = "purchaseNumMessage";

    private String VIEW_NAME = "itemlist";


    public ListView(String message, int cartItemNum,
        ListForm listForm, List<Item> items,
        String test, String yName, String eName, String speed,
        String itamaeName, String chefName, String cooking,
        String beefName, String porkName,
        String salmonName, String vegetableName, String food,
        int purchaseNum) {

        if (message != null && !message.isEmpty()) {
            this.addObject(ATTRIBUTE_NAME_MESSAGE, message);
            this.addObject(ATTRIBUTE_NAME_TEST, test);
        }

        StringBuilder cartItemNumBuf = new StringBuilder();
        cartItemNumBuf.append(cartItemNum);
        cartItemNumBuf.append("点の商品がカートに入っています。");
        this.addObject(ATTRIBUTE_NAME_CART_ITEM_NUM, cartItemNumBuf.toString());

        this.addObject(ATTRIBUTE_NAME_ITEMS, items);
        this.addObject(ATTRIBUTE_NAME_LIST_FORM, listForm);

        this.addObject(testDisplay, "成功！");
        this.addObject("youngerName", yName);
        this.addObject("elderName", eName);
        this.addObject("speed", speed);
        this.addObject("itamaeName", itamaeName);
        this.addObject("chefName", chefName);
        this.addObject("cooking", cooking);
        this.addObject("beefName", beefName);
        this.addObject("porkName", porkName);
        this.addObject("salmonName", salmonName);
        this.addObject("vegetableName", vegetableName);
        this.addObject("food", food);

        StringBuilder purchaseNumBuf = new StringBuilder();
        purchaseNumBuf.append(purchaseNum);
        purchaseNumBuf.append("回注文しました。");
        this.addObject(ATTRIBUTE_NAME_PURCHASE_NUM, purchaseNumBuf.toString());

        this.setViewName(VIEW_NAME);
    }
}
