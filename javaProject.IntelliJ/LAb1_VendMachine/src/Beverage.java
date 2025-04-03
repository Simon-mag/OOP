public class Beverage {

    private String name;
    private double price;
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

    public void setName(String name)  {this.name = name;}
    public void setPrice(double price){this.price = price;}
    public void setStock(int stock)   {this.stock = stock;}
    public void increaseTimesSelected(){++this.timesSelected;}

    public String getName()  {return name;}
    public double getPrice()  {return price;}
    public int getStock()       {return stock;}
    public int getTimesSelected() {return timesSelected;}
}
