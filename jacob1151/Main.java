import java.util.LinkedList;
import java.util.Optional;
import java.util.Scanner;

public class Main {
    private void run(){
        Scanner scanner= new Scanner(System.in);
        System.out.println("1) Add a depot");
        System.out.println("2) Remove a depot");
        System.out.println("3) Add a product to a depot");
        System.out.println("4) Remove one item of a product from a depot");
        System.out.println("5) List of depot");
        System.out.println("6) List of products in a depot");
        System.out.println("7) Products presence in the depots");
        System.out.println("8) Cumulative value of all products in a depot");
        System.out.println("9) Exit");

        boolean controller = true;
        Depot depot1 = new Depot();
        Depot depot2 = new Depot();
        while (controller == true){
        System.out.print("\n Select the Option by respective number : ");
        int option = Integer.parseInt((scanner.nextLine()).toLowerCase());
            switch (option){
                case 1:
                    depot1.addDepot();
                    break;
                case 2:
                    depot1.removeDepot();
                    break;
                case 3:
                    depot1.addProduct();
                    break;
                case 4:
                    depot1.removeProduct();
                    break;
                case 5:
                    depot1.showDepotList();
                    break;
                case 6:
                    depot1.ListOfProducts();
                case 7:
                    depot1.ProductInDepots();
                case 8:
                    depot1.CumulativeValue();
                    break;
                default:
                    controller = false;
                    break;
            }
        }
    }

    public static void main(String[] args) {
        Main r = new Main();
        r.run();
    }
}
