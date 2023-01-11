import java.util.ArrayList;
import java.util.List;

public class BurgerShop {
    //TODO: Implement Part 1
    //TODO: Implement Part 3
    //TODO: Implement Part 4
    Burger burgerObj;
    Stock stockObj;


    public int calculateTotalPrice(Burger burger, Stock stockObj){ //Burger.ingredient= cheese, cutlet, bun

        setBurgerObj(burger);
        setStockObj(stockObj);

       List<String> BurgerIng= new ArrayList<String>();
       BurgerIng=burger.getIngredients();
       int len=BurgerIng.size();
       int price=0;
        for(int i=0; i<len; i++){
            //System.out.println(BurgerIng.get(i));
            if(stockObj.stockIng[i].getName() == burger.getIngredients().get(i)){
                price=price+stockObj.stockIng[i].getPrice();
            }
        }
        return price;
    }
    public void acceptSuppplyDelivery(String name, int price, int quantity){
        int len = stockObj.stockIng.length;
        int chek = 0;
        for(int i=0;i<len; i++){
            if(stockObj.stockIng[i].getName() == name){
                chek = 1;
                stockObj.stockIng[i].setQuantity(stockObj.stockIng[i].getQuantity() + quantity);
            }
        }
        if(chek == 0){
            System.out.println("No ingridient with the given name exists yet");
        }
    }


    public void orderBurger(Burger burger){
        List<String> ingredients=new ArrayList<String>();
        ingredients.add("bun");
        ingredients.add("cutlet");
        ingredients.add("cheese");
        Burger BurgerObj = new Burger("Double-Cheeseburger", ingredients);
        checkOrderReady();
    }
    public void checkOrderReady() {
        if (getBurgerObj().OrderPlaced == 1){
            getBurgerObj().OrderCompleted = 1;
            getBurgerObj().OrderPlaced = 0;
            System.out.println("The Order is ready : "+ getBurgerObj().getName());
        }else{
            System.out.println("Order for " + getBurgerObj().getName() + " is not ready");
        }
    }

    public void setBurgerObj(Burger burgerObj) {
        this.burgerObj = burgerObj;
    }

    public void setStockObj(Stock stockObj) {
        this.stockObj = stockObj;
    }

    public Burger getBurgerObj() {
        return burgerObj;
    }

    public Stock getStockObj() {
        return stockObj;
    }
}
