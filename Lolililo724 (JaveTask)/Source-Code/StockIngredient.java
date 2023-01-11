import java.util.ArrayList;
import java.util.List;

public class StockIngredient {
    //TODO: Implement Part 1

    private String name;
    private int price;
    private int quantity;

    StockIngredient(String name, int price, int quantity){
           if(name!=null){
               this.name=name;
           }else {
               this.name = "";
           }
           if(price>=0){
               this.price=price;
           }else{
               this.price = 0;
           }
           if(quantity >=0){
               this.quantity=quantity;
           }else {
               this.quantity = 0;
           }
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }



    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getPrice() {
        return price;
    }
}