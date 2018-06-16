package jp.co.systena.tigerscase.SpringHelloSystena.controller;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import jp.co.systena.tigerscase.SpringHelloSystena.model.Cart;
import jp.co.systena.tigerscase.SpringHelloSystena.model.CartForm;
import jp.co.systena.tigerscase.SpringHelloSystena.model.CartView;
import jp.co.systena.tigerscase.SpringHelloSystena.model.Order;
import jp.co.systena.tigerscase.SpringHelloSystena.model.Purchase;

@Controller
public class CartController extends BaseController {
    @RequestMapping(value="/cart", method = RequestMethod.GET)
    public ModelAndView show(/*ModelAndView mav*/) {
        String message = getMessageFromSession();
        removeMessageFromSession();

        Cart cart = getCartFromSession();

        Purchase purchase = getPurchaseFromSession();
        int totalPurchasePrice = purchase.getTotalPurchasePrice();
        int totalPurchaseSpeed = purchase.getTotalPurchaseSpeed();

        List<Purchase> purchaseLists = new ArrayList<Purchase>();
        purchaseLists.add(purchase);

        ModelAndView mav = new CartView(message, cart, new CartForm(),
            totalPurchasePrice, totalPurchaseSpeed, purchaseLists,
            purchase);
        return mav;
    }

    @RequestMapping(value="/cart", method = RequestMethod.POST)
    private ModelAndView remove(/*ModelAndView mav, */
        @Valid CartForm cartForm,
        BindingResult bindingResult,
        HttpServletRequest request) {
        Cart cart = getCartFromSession();
        Order order = cart.findOrderByItemId(cartForm.getItemId());

        //Purchase purchase = getPurchaseFromSession();

        String message;
        if (cart.remove(order)) {
            message = order.getItem().getName() + "をカートから削除しました。";
        } else {
            message = "削除処理でエラーが発生しました。";
        }

        // データをセッションへ保存
        setMessageFromSession(message);
        setCartFromSession(cart);

        // リダイレクト
        return new ModelAndView("redirect:/cart");
    }
}
