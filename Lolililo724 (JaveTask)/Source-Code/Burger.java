import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Burger {
    //TODO: Implement Part 1
    private String name;
    private List<String> ingredients=new ArrayList<String>(); //cheese, bun, cutlet
    int OrderPlaced = 0;
    int OrderCompleted = 0;
    Burger(String name, List<String> list){
        this.name = name;
        this.ingredients = list;
        OrderPlaced = 1; // It means order has been created
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public String getName() {
        return name;
    }
}
