package jp.co.systena.tigerscase.SpringHelloSystena.model;

public class ListForm {
    private int itemId;
    private int num;
    private String itemName;

    private String selectedCostomer;
    private String selectedCock;
    private String selectedFood;

    public int getItemId() {
        return this.itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getNum() {
        return this.num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getItemName() {
      return itemName;
    }

    public void setItemName(String itemName) {
      this.itemName = itemName;
    }

    public String getSelectedCostomer() {
      return selectedCostomer;
    }

    public void setSelectedCostomer(String selectedCostomer) {
      this.selectedCostomer = selectedCostomer;
    }

    public String getSelectedCock() {
      return selectedCock;
    }

    public void setSelectedCock(String selectedCock) {
      this.selectedCock = selectedCock;
    }

    public String getSelectedFood() {
      return selectedFood;
    }

    public void setSelectedFood(String selectedFood) {
      this.selectedFood = selectedFood;
    }
}
