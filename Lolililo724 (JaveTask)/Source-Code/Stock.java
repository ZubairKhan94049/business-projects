public class Stock {
    //TODO: Implement Part 1
    //TODO: Implement Part 2

    StockIngredient stockIng[];

    Stock(StockIngredient SI[])
    {
        stockIng=SI;
    }
    public int add(String name){
        int i=0;
        int quant=0;
        for (i = 0; i < stockIng.length; i++){
            if (stockIng[i].getName() == name) {
                stockIng[i].setQuantity(stockIng[i].getQuantity() + 1);
                quant=stockIng[i].getQuantity();
            }
        }
        return quant;
    }
    public int take(String name) {
        int i=0;
        int quant=0;
        for (i = 0; i < stockIng.length; i++){
            if (stockIng[i].getName() == name) {
                stockIng[i].setQuantity(stockIng[i].getQuantity() - 1);
                quant=stockIng[i].getQuantity();
            }
        }
        return quant;
    }
    public StockIngredient findStockIngredient(String name){
        StockIngredient si = new StockIngredient("A", 1,3);
        return si;
    }
}