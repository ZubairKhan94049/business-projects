import java.util.LinkedList;

public class Product {
    private String name;
    private double price;
    private double weight;
    private int quantity;

    // Setters functions
    public void setName(String name) {
        this.name = name.toLowerCase();
    }
    public void setPrice(double price) {
        if (price > 0) {
            this.price = price;
        }else {
            System.out.println("Price must be a positive number ");
            return;
        }
    }
    public void setQuantity(int quantity) {
        if (price > 0) {
            this.quantity = quantity;
        }else {
            System.out.println("Quantity must be a positive number");
            return;
        }
    }
    public void setWeight(double weight) {
        if (weight > 0) {
            this.weight = weight;
        }else {
            System.out.println("Weight must be a positive number");
            return;
        }
    }
    public String getName(){
        return name;
    }
    public double getPrice(){
        return price;
    }
    public double getWeight(){
        return weight;
    }
    public int getQuantity(){
        return quantity;
    }

}
