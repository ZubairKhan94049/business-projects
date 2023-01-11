import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //TODO: Test your solution here


        List<String> ingredients=new ArrayList<String>();
        ingredients.add("bun");
        ingredients.add("cutlet");
        ingredients.add("cheese");

        final int NoOfItems=3;
        StockIngredient[] StockIngredientObj = new StockIngredient[NoOfItems] ;
        StockIngredientObj[0] = new StockIngredient("bun", 2, 3);
        StockIngredientObj[1] = new StockIngredient("cutlet", 3, 2);
        StockIngredientObj[2]= new StockIngredient("cheese", 4, 5);

        Stock StockObj = new Stock(StockIngredientObj);
        StockObj.take("cheese");
        StockObj.add("bun");


        Burger BurgerObj = new Burger("Double-Cheeseburger", ingredients);

        BurgerShop burgerShop= new BurgerShop();
        burgerShop.calculateTotalPrice(BurgerObj, StockObj);

        burgerShop.checkOrderReady();
    }
}