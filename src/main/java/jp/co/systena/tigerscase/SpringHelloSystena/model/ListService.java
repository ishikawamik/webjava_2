package jp.co.systena.tigerscase.SpringHelloSystena.model;

import java.util.ArrayList;
import java.util.List;

public class ListService {
    private List<Item> itemList = new ArrayList<Item>();

    public ListService() {
        itemList.add(new Item(1, "AAAAA",100));
  }

    public List<Item> getItemList() {
        return itemList;
    }

    public Item findItemById(int id) {
        for (Item item : itemList) {
            if (item.getId() == id) return item;
        }
        return null;
    }
}
