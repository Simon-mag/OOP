package UserInformation;

import java.io.Serial;
import java.io.Serializable;

public class User implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private String userName;
    private String password;
    private String firstName;
    private String lastName;
    private String address;
    private String phoneNumber;


    public User(){}
    public User(String userName, String password, String firstName, String lastName, String address, String phoneNumber){
        this.userName = userName;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phoneNumber = phoneNumber;

    }

    public String getPhoneNumber() {return phoneNumber;}
    public String getFirstName() {return firstName;}
    public String getPassword() {return password;}
    public String getLastName() {return lastName;}
    public String getUserName() {return userName;}
    public String getAddress() {return address;}


    public void setPhoneNumber(String phoneNumber){this.phoneNumber = phoneNumber ;}
    public void setFirstName(String firstName){this.firstName = firstName ;}
    public void setPassword(String password){this.password = password ;}
    public void setLastName(String lastName){this.lastName = lastName ;}
    public void setUserName(String userName){this.userName = userName ;}
    public void setAddress(String address){this.address = address ;}



}
