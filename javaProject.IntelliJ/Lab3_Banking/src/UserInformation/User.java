package UserInformation;

public class User {
    private String userName;
    private String password;
    private String firstName;
    private String lastName;
    private String address;
    private String phoneNumber;
    private double balance;

    public User(){}
    public User(String userName, String password, String firstName, String lastName, String address, String phoneNumber, double balance){
        this.userName = userName;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.balance = balance;
    }

    public String getPhoneNumber() {return phoneNumber;}
    public String getFirstName() {return firstName;}
    public String getPassword() {return password;}
    public String getLastName() {return lastName;}
    public String getUserName() {return userName;}
    public String getAddress() {return address;}
    public double getBalance() {return balance;}

    public void setPhoneNumber(String phoneNumber){this.phoneNumber = phoneNumber ;}
    public void setFirstName(String firstName){this.firstName = firstName ;}
    public void setPassword(String password){this.password = password ;}
    public void setLastName(String lastName){this.lastName = lastName ;}
    public void setUserName(String userName){this.userName = userName ;}
    public void setAddress(String address){this.address = address ;}
    public void setBalance(double balance){this.balance = balance ;}


}
