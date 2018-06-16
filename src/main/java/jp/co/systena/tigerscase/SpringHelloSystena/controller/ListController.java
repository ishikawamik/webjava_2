package jp.co.systena.tigerscase.SpringHelloSystena.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import jp.co.systena.tigerscase.SpringHelloSystena.model.Beef;
import jp.co.systena.tigerscase.SpringHelloSystena.model.Cart;
import jp.co.systena.tigerscase.SpringHelloSystena.model.Chef;
import jp.co.systena.tigerscase.SpringHelloSystena.model.Elder;
import jp.co.systena.tigerscase.SpringHelloSystena.model.Itamae;
import jp.co.systena.tigerscase.SpringHelloSystena.model.Item;
import jp.co.systena.tigerscase.SpringHelloSystena.model.ListForm;
import jp.co.systena.tigerscase.SpringHelloSystena.model.ListService;
import jp.co.systena.tigerscase.SpringHelloSystena.model.ListView;
import jp.co.systena.tigerscase.SpringHelloSystena.model.Message;
import jp.co.systena.tigerscase.SpringHelloSystena.model.Msg;
import jp.co.systena.tigerscase.SpringHelloSystena.model.Order;
import jp.co.systena.tigerscase.SpringHelloSystena.model.Pork;
import jp.co.systena.tigerscase.SpringHelloSystena.model.Purchase;
import jp.co.systena.tigerscase.SpringHelloSystena.model.Salmon;
import jp.co.systena.tigerscase.SpringHelloSystena.model.Vegetable;
import jp.co.systena.tigerscase.SpringHelloSystena.model.Younger;

@Controller
public class ListController extends BaseController {

  Younger younger = new Younger();
  Elder elder = new Elder();

  Chef chef = new Chef();
  Itamae itamae = new Itamae();

  Beef beef =  new Beef();
  Pork pork = new Pork();
  Salmon salmon = new Salmon();
  Vegetable vegetable = new Vegetable();

  @RequestMapping(value="/itemlist", method = RequestMethod.GET)
    public ModelAndView show(/*Costomer c*/) {
        String message = getMessageFromSession();
        removeMessageFromSession();

        Cart cart = getCartFromSession();

        String test = getTestFromSession();
        removeTestFromSession();

        String speed = getSpeedFromSession();
        removeSpeedFromSession();

        String cooking = getCookingFromSession();
        removeCookingFromSession();

        String food = getFoodFromSession();
        removeFoodFromSession();

        Purchase selectMsg = getPurchaseFromSession();


        ModelAndView mav = new ListView(message, cart.getItemNum(),
            new ListForm(), new ListService().getItemList(),
            test, younger.getName(), elder.getName(), speed,
            itamae.getName(), chef.getName() , cooking,
            beef.getName(), pork.getName(),
            salmon.getName(), vegetable.getName(), food,
            selectMsg.getpurchaseNum());
        return mav;
    }

    @RequestMapping(value="/itemlist", method = RequestMethod.POST)
    private ModelAndView order(/*ModelAndView mav, */
        @Valid ListForm listForm,
        BindingResult bindingResult,
        HttpServletRequest request) {
        boolean isError = false;
        Item item = null;
        if (bindingResult.getAllErrors().size() > 0) {
            isError = true;
        } else {
            item = new ListService().findItemById(listForm.getItemId());
        }

        if (isError == true || item == null) {
            // エラー(動作未確認)
            setMessageFromSession("エラーが発生しました。");
            // リダイレクト
            return new ModelAndView("redirect:/itemlist");
        }

        Order order = new Order(item, listForm.getNum());
        Cart cart = getCartFromSession();
        cart.add(order);

        StringBuilder messageBuf = new StringBuilder();
        messageBuf.append(item.getName());
        messageBuf.append("を");
        messageBuf.append(listForm.getNum());
        messageBuf.append("点カートに追加しました。");

        // データをセッションへ保存
        setMessageFromSession(messageBuf.toString());
        setCartFromSession(cart);

        StringBuilder testBuf = new StringBuilder();
        testBuf.append(listForm.getItemName());
        testBuf.append("をカートに追加しました。");
        setTestFromSession(testBuf.toString());

        StringBuilder costomerMsg = new StringBuilder();
        String selectedCostomer = listForm.getSelectedCostomer();
        int speed = 0;
        if (selectedCostomer.equals(younger.getName())) {
          speed = younger.eat();
          costomerMsg.append(speed);
        } else if (selectedCostomer.equals(elder.getName())){
          speed = elder.eat();
          costomerMsg.append(speed);
        }
        costomerMsg.append("秒かかりました。");
        setSpeedFromSession(costomerMsg.toString());

        StringBuilder cockMsg = new StringBuilder();
        String selectedCock = listForm.getSelectedCock();
        String cooking = null;
        if (selectedCock.equals(itamae.getName())) {
          cooking = itamae.cook();
          cockMsg.append(cooking);
        } else if (selectedCock.equals(chef.getName())){
          cooking = chef.cook();
          cockMsg.append(cooking);
        }

        cockMsg.append("を注文しました。");
        setCookingFromSession(cockMsg.toString());

        StringBuilder foodMsg = new StringBuilder();
        foodMsg.append(listForm.getSelectedFood());
        foodMsg.append("の");
        setFoodFromSession(foodMsg.toString());

        String selectedFood = listForm.getSelectedFood();
        int price = 0;
        if (selectedFood.equals(beef.getName())) {
          price = beef.getPrice();
          StringBuilder foodPrice = new StringBuilder();
          foodPrice.append(price);
          setFoodPriceFromSession(foodPrice.toString());
        } else if (selectedFood.equals(pork.getName())){
          price = pork.getPrice();
          StringBuilder foodPrice = new StringBuilder();
          foodPrice.append(price);
          setFoodPriceFromSession(foodPrice.toString());
        } else if (selectedFood.equals(salmon.getName())) {
          price = salmon.getPrice();
          StringBuilder foodPrice = new StringBuilder();
          foodPrice.append(price);
          setFoodPriceFromSession(foodPrice.toString());
        } else if (selectedFood.equals(vegetable.getName())) {
          price = vegetable.getPrice();
          StringBuilder foodPrice = new StringBuilder();
          foodPrice.append(price);
          setFoodPriceFromSession(foodPrice.toString());
        }
        // データをセッションへ保存
        setMessageFromSession(messageBuf.toString());
        setCartFromSession(cart);

        Message selectMsg = new Message(speed, cooking , price);
        Msg msg = new Msg(selectMsg, 1);
        Purchase purchase = getPurchaseFromSession();
        purchase.addNum(msg);
        setPurchaseFromSession(purchase);

        // リダイレクト
        return new ModelAndView("redirect:/itemlist");
    }
}
