public class Beverage {

    private final String name;
    private final double price;
    private int stock;
    private int timesSelected;

    public Beverage(String name, double price, int stock){
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.timesSelected = 0;
    }

    public void decreaseStock(){
        if(stock > 0)
            --this.stock;
    }

    public void increaseTimesSelected(){++this.timesSelected;}
    public void setStock(int stock){this.stock = stock;}

    public String getName()  {return name;}
    public double getPrice()  {return price;}
    public int getStock()       {return stock;}
    public int getTimesSelected() {return timesSelected;}
}
