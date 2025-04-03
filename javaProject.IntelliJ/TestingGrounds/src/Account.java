public class Account {
    private String name;
    private double balance;
    private boolean isEmployed;

    public Account(String name, double balance, boolean Employed){
        this.name = name;
        this.isEmployed = Employed;
        if(balance > 0)
            this.balance = balance;
    }

    public void setEmployed(boolean status){
        isEmployed = status;
    }
    public boolean isEmployed(){
        return isEmployed;
    }

    public double currentBalance(){
        return balance;
    }

    public void addBalance(double amount){
        balance += amount;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName(){
        return name;
    }
}
