import java.util.*;

public class Depot{
    private String name;
    private final Product product1 = new Product();
    private final Product product2 = new Product();
    private final Product product3 = new Product();
            //, product2, product3;
    private final LinkedList<String> depot_list = new LinkedList<String>();
    private final LinkedList<String> first_depot_products = new LinkedList<String>();
    private final LinkedList<String> second_depot_products = new LinkedList<String>();

    ////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////
    private final LinkedList<String> d1_p1_name = new LinkedList<String>();
    private final LinkedList<Double> d1_p1_price = new LinkedList<Double>();
    private final LinkedList<Double> d1_p1_weight = new LinkedList<Double>();
    private final LinkedList<Integer> d1_p1_quantity = new LinkedList<Integer>();
        // For Product 02

    private final LinkedList<String> d1_p2_name = new LinkedList<String>();
    private final LinkedList<Double> d1_p2_price = new LinkedList<Double>();
    private final LinkedList<Double> d1_p2_weight = new LinkedList<Double>();
    private final LinkedList<Integer> d1_p2_quantity = new LinkedList<Integer>();

        // For Product 03
    private final LinkedList<String> d1_p3_name = new LinkedList<String>();
    private final LinkedList<Double> d1_p3_price = new LinkedList<Double>();
    private final LinkedList<Double> d1_p3_weight = new LinkedList<Double>();
    private final LinkedList<Integer> d1_p3_quantity = new LinkedList<Integer>();


    ///////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////
    private final LinkedList<String> d2_p1_name = new LinkedList<String>();
    private final LinkedList<Double> d2_p1_price = new LinkedList<Double>();
    private final LinkedList<Double> d2_p1_weight = new LinkedList<Double>();
    private final LinkedList<Integer> d2_p1_quantity = new LinkedList<Integer>();
    // For Product 02

    private final LinkedList<String> d2_p2_name = new LinkedList<String>();
    private final LinkedList<Double> d2_p2_price = new LinkedList<Double>();
    private final LinkedList<Double> d2_p2_weight = new LinkedList<Double>();
    private final LinkedList<Integer> d2_p2_quantity = new LinkedList<Integer>();

    // For Product 03
    private final LinkedList<String> d2_p3_name = new LinkedList<String>();
    private final LinkedList<Double> d2_p3_price = new LinkedList<Double>();
    private final LinkedList<Double> d2_p3_weight = new LinkedList<Double>();
    private final LinkedList<Integer> d2_p3_quantity = new LinkedList<Integer>();



    ////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////

    Scanner scanner= new Scanner(System.in);    //System.in is a standard input stream


    /// Adding Products
    public void addProduct(){
        System.out.print("Name of depot you want to add the product ? ");
        String depotName = (scanner.nextLine()).toLowerCase();
        int depotIndex = -1; // To check in which depot you want to add the product so that it will select the prodcut list accordingly
        if(depot_list.size() == 0){
            System.out.println("You Must add Depot first ");
        }else {
            for (int i = 0 ; i<depot_list.size();i++){
                if (Objects.equals(depot_list.get(i), depotName)){
                    depotIndex = i;
                    break;
                }
            }
            if (depotIndex == 0){
                System.out.print("Enter the product name : ");
                String productName = (scanner.nextLine()).toLowerCase();
                addProductInFirstDepot(productName);
            }else if(depotIndex == 1){
                System.out.print("Enter the product name : ");
                String productName = (scanner.nextLine()).toLowerCase();
                addProductInSecondDepot(productName);
            }
        }
        if (depotIndex == -1){
            System.out.println("This Depot Does not Exists ");
        }
    } //
    public void addProductInFirstDepot(String pName){
        int check = 1;
        for (int i =0 ;i<first_depot_products.size(); i++){
            if(Objects.equals(first_depot_products.get(i), pName)){
                System.out.println("This Product is already Exists ");
                check = 0;
                break;
            }
        }
        if (check == 1){
            System.out.print("Enter Price for "+pName+" : ");
            double productPrice = Double.parseDouble(scanner.nextLine());
            System.out.print("Enter Weight for "+pName+" : ");
            double productWeight = Double.parseDouble(scanner.nextLine());
            System.out.print("Enter Quantity for "+pName+" : ");
            int productQuantity = Integer.parseInt(scanner.nextLine());
            if(first_depot_products.size() == 0){
                product1.setName(pName);
                d1_p1_name.add(product1.getName());
                first_depot_products.add(product1.getName());

                product1.setPrice(productPrice);
                d1_p1_price.add(product1.getPrice());

                product1.setQuantity(productQuantity);
                d1_p1_quantity.add(product1.getQuantity());

                product1.setWeight(productWeight);
                d1_p1_weight.add(product1.getWeight());
            }
            else if(first_depot_products.size() == 1){
                product2.setName(pName);
                d1_p2_name.add(product2.getName());
                first_depot_products.add(product2.getName());

                product1.setPrice(productPrice);
                d1_p2_price.add(product2.getPrice());

                product2.setQuantity(productQuantity);
                d1_p2_quantity.add(product2.getQuantity());

                product1.setWeight(productWeight);
                d1_p2_weight.add(product2.getWeight());
            }
            else if(first_depot_products.size() == 2){
                product3.setName(pName);
                d1_p3_name.add(product3.getName());
                first_depot_products.add(product3.getName());

                product3.setPrice(productPrice);
                d1_p3_price.add(product3.getPrice());

                product3.setQuantity(productQuantity);
                d1_p3_quantity.add(product3.getQuantity());

                product3.setWeight(productWeight);
                d1_p3_weight.add(product3.getWeight());
            }
            else if(first_depot_products.size() == 3){
                System.out.println("This Depot is reach to it maximum(3 Products) ");
            }
        }
    }
    public void addProductInSecondDepot(String pName){
        int check = 1;
        for (int i =0 ;i<second_depot_products.size(); i++){
            if(Objects.equals(first_depot_products.get(i), pName)){
                System.out.println("This Product is already Exists ");
                check = 0;
                break;
            }
        }
        if (check == 1){
            System.out.print("Enter Price for "+pName+" : ");
            double productPrice = Double.parseDouble(scanner.nextLine());
            System.out.print("Enter Weight for "+pName+" : ");
            double productWeight = Double.parseDouble(scanner.nextLine());
            System.out.print("Enter Quantity for "+pName+" : ");
            int productQuantity = Integer.parseInt(scanner.nextLine());
            if(second_depot_products.size() == 0){
                product1.setName(pName);
                d2_p1_name.add(product1.getName());
                second_depot_products.add(product1.getName());

                product1.setPrice(productPrice);
                d2_p1_price.add(product1.getPrice());

                product1.setQuantity(productQuantity);
                d2_p1_quantity.add(product1.getQuantity());

                product1.setWeight(productWeight);
                d2_p1_weight.add(product1.getWeight());
            }
            else if(second_depot_products.size() == 1){
                product2.setName(pName);
                d2_p2_name.add(product2.getName());
                second_depot_products.add(product2.getName());

                product1.setPrice(productPrice);
                d2_p2_price.add(product2.getPrice());

                product2.setQuantity(productQuantity);
                d2_p2_quantity.add(product2.getQuantity());

                product1.setWeight(productWeight);
                d2_p2_weight.add(product2.getWeight());
            }
            else if(second_depot_products.size() == 2){
                product3.setName(pName);
                d2_p3_name.add(product3.getName());
                second_depot_products.add(product3.getName());

                product3.setPrice(productPrice);
                d2_p3_price.add(product3.getPrice());

                product3.setQuantity(productQuantity);
                d2_p3_quantity.add(product3.getQuantity());

                product3.setWeight(productWeight);
                d2_p3_weight.add(product3.getWeight());
            }else if(second_depot_products.size() == 3){
                System.out.println("This Depot is reach to it maximum(3 Products) ");
            }
        }
    }
    /// Adding Products Function Ended

    // Removing Products
    public void removeProduct(){
        System.out.print("Name of depot you want to remove the product ? ");
        String depotName = (scanner.nextLine()).toLowerCase();
        int depIndex = -1;
        for (int i =0; i<depot_list.size(); i++){
            if(Objects.equals(depot_list.get(i), depotName)){
                depIndex = i;
                break;
            }
        }
        if (depIndex == -1){
            System.out.println(depotName +" Does not Exists, please Enter again : ");
        }else if(depIndex == 0){
            removeProductFromFirstDepot(depotName);
        }else if(depIndex == 1){
            removeProductFromSecondDepot(depotName);
        }
    }
    public void removeProductFromFirstDepot(String dName){
        int index = -1; // Index use to remove price, weight, quantity etc too for that product
        int total = first_depot_products.size();
        System.out.print("Product name ? ");
        String productName = (scanner.nextLine()).toLowerCase();
        for(int i = 0 ; i<first_depot_products.size(); i++){
            if(Objects.equals(first_depot_products.get(i), productName)){
                first_depot_products.remove(i);
                index = i;
                break;
            }
        }
        if (index != 0){
            if(total == 1){
                d1_p1_name.remove(index);
                d1_p1_price.remove(index);
                d1_p2_quantity.remove(index);
                d1_p1_weight.remove(index);
                System.out.println("One item of Product "+productName+" removed from depot "+dName);
            }else if(total == 2){
                d1_p2_name.remove(index);
                d1_p2_price.remove(index);
                d1_p2_quantity.remove(index);
                d1_p2_weight.remove(index);
                System.out.println("One item of Product "+productName+" removed from depot "+dName);
            }else if (total == 3){
                d1_p3_name.remove(index);
                d1_p3_price.remove(index);
                d1_p3_quantity.remove(index);
                d1_p3_weight.remove(index);
                System.out.println("One item of Product "+productName+" removed from depot "+dName);
            }else {
                System.out.println("Depot is Empty ... ");
            }
        }else{
            System.out.println("This Product does not exists ");
        }
    }
    public void removeProductFromSecondDepot(String dName){
        int index = -1; //
        int total = second_depot_products.size();// Index use to remove price, weight, quantity etc too for that product
        System.out.print("Product name ? ");
        String productName = (scanner.nextLine()).toLowerCase();
        for(int i = 0 ; i<second_depot_products.size(); i++){
            if(Objects.equals(second_depot_products.get(i), productName)){
                second_depot_products.remove(i);
                index = i;
                break;
            }
        }
        if (index != 0){
            if(total == 1){
                d2_p1_name.remove(index);
                d2_p1_price.remove(index);
                d2_p2_quantity.remove(index);
                d2_p1_weight.remove(index);
                System.out.println("One item of Product "+productName+" removed from depot "+dName);
            }else if(total == 2){
                d2_p2_name.remove(index);
                d2_p2_price.remove(index);
                d2_p2_quantity.remove(index);
                d2_p2_weight.remove(index);
                System.out.println("One item of Product "+productName+" removed from depot "+dName);
            }else if (total == 3){
                d2_p3_name.remove(index);
                d2_p3_price.remove(index);
                d2_p3_quantity.remove(index);
                d2_p3_weight.remove(index);
                System.out.println("One item of Product "+productName+" removed from depot "+dName);
            }else {
                System.out.println("Depot is Empty ... ");
            }
        }else{
            System.out.println("This Product does not exists ");
        }
    }
    /// Removing Products Function Ended

    public String getName() {
        return name;
    }
    public void addDepot() {
        System.out.print("Enter name of Depot to add: ");
        this.name = (scanner.nextLine()).toLowerCase(); // Convert Deport name to lower case
        int check = 0;  // Check either the name alrea
        if (depot_list.size() == 0 || depot_list.size() < 2){
            for (String i: depot_list){
                if (Objects.equals(this.name, i)){
                    check = 1;
                    System.out.println("Deport "+name+" Already Exists");
                    break;
                }
            }
            if (check != 1){
                depot_list.add(this.name);
                System.out.println("Deport "+ this.name + " Successfully added ");
            }
        }else {
            System.out.println("Size of is deport is 2, can not add more");
        }
    }
    public int removeDepot(){
        System.out.print("Enter name of Depot to remove: ");
        this.name = (scanner.nextLine()).toLowerCase();
        // To remove first we have to check either it is present in it or not
        int check = 0;
        for (String i: depot_list){
            if (Objects.equals(this.name, i)){
                depot_list.remove(this.name);
                check = 1;
                System.out.println("Depot "+ this.name +" Successfully removed " );
                return 1;
            }
        }
        if (check == 0){
            System.out.println ("Depot "+ this.name +" can not be removed as it is not present" );
            return 0;
        }
        return 1;
    }
    public void showDepotList(){
        if (depot_list.size() == 0){
            System.out.println("No Depots exist");
            return;
        }else {
            for (int i = 0; i< depot_list.size(); i++){
                if (i == 0){
                    System.out.println("Depot "+depot_list.get(i)+" Has "+first_depot_products.size()+" Products");
                }
                if (i == 1){
                    System.out.println("Depot "+depot_list.get(i)+" Has "+second_depot_products.size()+" Products");
                }

            }
        }
    }
    public void ListOfProducts(){
        System.out.print("Enter Depot Name to List its Products : ");
        String depotName = (scanner.nextLine()).toLowerCase();
        int depotIndex = -1;
        for(int i = 0; i<depot_list.size(); i++){
            if (Objects.equals(depotName, depot_list.get(i))){
                depotIndex = i;
                break;
            }
        }
        if(depotIndex == -1){
            System.out.println("No Such Depot is Present ");
            return;
        }else if(depotIndex == 0){
            listFirstDepot();
        }else if(depotIndex == 1){
            listSecondDepot();
        }

    }
    public void listFirstDepot(){
        if(first_depot_products.size() == 1){
            for (int i=0; i<first_depot_products.size(); i++){
                System.out.println("Product "+ d1_p1_name.get(i) + " har price "+d1_p1_price.get(i)+", weight " +d1_p1_weight.get(i) +"kg, and quantity "+d1_p1_quantity.get(i));
            }
        }else if(first_depot_products.size() == 2){
            for (int i=0; i<first_depot_products.size(); i++){
                System.out.println("Product "+ d1_p2_name.get(i) + " har price "+d1_p2_price.get(i)+", weight " +d1_p2_weight.get(i) +"kg, and quantity "+d1_p2_quantity.get(i));
            }
        }else if(first_depot_products.size() == 3){
            for (int i=0; i<first_depot_products.size(); i++){
                System.out.println("Product "+ d1_p3_name.get(i) + " har price "+d1_p3_price.get(i)+", weight " +d1_p3_weight.get(i) +"kg, and quantity "+d1_p3_quantity.get(i));
            }
        }else if(first_depot_products.size() == 0){
            System.out.println("No Products in Depot");
        }
    }
    public void listSecondDepot(){
        if(second_depot_products.size() == 1){
            for (int i=0; i<second_depot_products.size(); i++){
                System.out.println("Product "+ d2_p1_name.get(i) + " har price "+d2_p1_name.get(i)+", weight " +d2_p1_name.get(i) +"kg, and quantity "+d2_p1_name.get(i));
            }
        }else if(second_depot_products.size() == 2){
            for (int i=0; i<second_depot_products.size(); i++){
                System.out.println("Product "+ d2_p2_name.get(i) + " har price "+d2_p2_name.get(i)+", weight " +d2_p2_name.get(i) +"kg, and quantity "+d2_p2_name.get(i));
            }
        }else if(second_depot_products.size() == 3){
            for (int i=0; i<second_depot_products.size(); i++){
                System.out.println("Product "+ d2_p3_name.get(i) + " har price "+d2_p3_name.get(i)+", weight " +d2_p3_name.get(i) +"kg, and quantity "+d2_p3_name.get(i));
            }
        }else if(second_depot_products.size() == 0){
            System.out.println("No Products in Depot");
        }
    }
    /// Task 07
    public void ProductInDepots(){
        System.out.print("Enter the Product name you want to search : ");
        String pName = (scanner.nextLine()).toLowerCase();
        int index = -1;
        for(int i =0;i<first_depot_products.size(); i++){
            if(Objects.equals(pName, first_depot_products.get(i))){
                System.out.print("Product " + pName + " is in depot "+ depot_list.get(0) + " with quantity ");
                index = i;
                break;
            }
        }
        if(first_depot_products.size() == 1 && index != -1){
            System.out.println(d1_p1_quantity.get(index));
        }else if(first_depot_products.size() == 2 && index != -1){
            System.out.println(d1_p2_quantity.get(index));
        }else if(first_depot_products.size() == 3 && index != -1){
            System.out.println(d1_p3_quantity.get(index));
        }

        //Else Search in Second Depot

        for(int i =0;i<second_depot_products.size(); i++){
            if(Objects.equals(pName, first_depot_products.get(i))){
                System.out.print("Product " + pName + " is in depot "+ depot_list.get(0) + " with quantity ");
                index = i;
                break;
            }
        }
        if(second_depot_products.size() == 1 && index != -1){
            System.out.println(d2_p1_quantity.get(index));
            return;
        }else if(second_depot_products.size() == 2 && index != -1){
            System.out.println(d2_p2_quantity.get(index));
            return;
        }else if(second_depot_products.size() == 3 && index != -1){
            System.out.println(d2_p3_quantity.get(index));
            return;
        }

    }

    public void CumulativeValue(){
        System.out.print("Enter the depot name for cumulative value : ");
        String depName = (scanner.nextLine()).toLowerCase();
        int depotIndex = -1;

        for(int i = 0; i<depot_list.size(); i++){
            if (Objects.equals(depot_list.get(i), depName)){
                depotIndex = i;
            }
        }
        for(int i = 0; i<depot_list.size(); i++){
            if(!Objects.equals(depot_list.get(i), depName)){
                System.out.println("This Depot Does not Exists");
                return;
            }
        }

        if(depotIndex == -1){
            System.out.println("Can not find the Depot ... plz try again ");
        }else if (depotIndex == 0){
            cumulativeOfFirstDepot(depName);
        }else if(depotIndex == 1){
            cumulativeOfSecondDepot(depName);
        }
    }
    public void cumulativeOfFirstDepot(String depotName){
        double cumValue = 0;
        if(first_depot_products.size() == 1){
            System.out.println("Depot "+depotName+" has cumulative product value "+ d1_p1_quantity.get(0) * d1_p1_price.get(0));
        }else if(first_depot_products.size() == 2){
            cumValue = (d1_p2_quantity.get(0) * d1_p2_price.get(0))+(d1_p2_quantity.get(1) * d1_p2_price.get(1));
            System.out.println("Depot "+depotName+" has cumulative product value " + cumValue);
        }else if(first_depot_products.size() == 3){
            cumValue = (d1_p3_quantity.get(0) * d1_p3_price.get(0))+(d1_p3_quantity.get(1) * d1_p3_price.get(1)) + (d1_p3_quantity.get(2) * d1_p3_price.get(2));
            System.out.println("Depot "+depotName+" has cumulative product value " + cumValue);
        }else if(first_depot_products.size() == 0){
            System.out.println("Depot is empty");
        }
    }
    public void cumulativeOfSecondDepot(String depotName){
        double cumValue = 0;
        if(second_depot_products.size() == 1){
            System.out.println("Depot "+depotName+" has cumulative product value "+ d2_p1_quantity.get(0) * d2_p1_price.get(0));
        }else if(second_depot_products.size() == 2){
            cumValue = (d2_p2_quantity.get(0) * d2_p2_price.get(0))+(d2_p2_quantity.get(1) * d2_p2_price.get(1));
            System.out.println("Depot "+depotName+" has cumulative product value " + cumValue);
        }else if(second_depot_products.size() == 3){
            cumValue = (d2_p3_quantity.get(0) * d2_p3_price.get(0))+(d2_p3_quantity.get(1) * d2_p3_price.get(1)) + (d2_p3_quantity.get(2) * d2_p3_price.get(2));
            System.out.println("Depot "+depotName+" has cumulative product value " + cumValue);
        }else if(second_depot_products.size() == 0){
            System.out.println("Depot is empty");
        }
    }
}