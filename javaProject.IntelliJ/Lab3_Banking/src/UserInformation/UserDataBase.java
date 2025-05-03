package UserInformation;

import java.io.*;
import java.util.Map;
import java.util.Scanner;


//so this class contains all the users at the same time instead of 1 at a time//
public class UserDataBase {

    private Map<String, User> users;

    public UserDataBase(){

        String line = "";
        try(Scanner reader = new Scanner(new FileReader("users.txt"))) {

            while(reader.hasNextLine()){

                line = reader.nextLine();
                String[] userInfo = line.split(",");

                if(userInfo.length != 7){
                    System.out.println("Invalid userInfo Format: " + line);
                    continue;
                }

                String username  = userInfo[0].trim();
                String password  = userInfo[1].trim();
                String firstName = userInfo[2].trim();
                String lastName  = userInfo[3].trim();
                String address   = userInfo[4].trim();
                String phone     = userInfo[5].trim();
                String balance   = userInfo[6].trim();

                if(validateUserInfo(username, password, firstName, lastName, address, phone, balance)){
                    double userBalance = Double.parseDouble(balance);
                    User user = new User(username, password, firstName, lastName, address, phone, userBalance);
                    users.put(username, user);
                }else
                    throw new RuntimeException(username);
            }


        } catch (NumberFormatException e){
            System.out.println("Balance is in wrong format");
        } catch (RuntimeException e){
            System.out.print("User did not have a valid format in \"users.txt\": " + e.getLocalizedMessage());
        } catch (IOException e){
            System.out.println("Failed to read File");
        }


    }


    private boolean validateUserInfo(
            String username,
            String password,
            String firstName,
            String lastName,
            String address,
            String phone,
            String balance)
    {
        return username.matches("^[A-Za-z][A-Za-z0-9_]{4,11}$") &&
               password.matches("^(?=.+[A-ZÅÄÖ])(?=.+\\d)(?=.+[!@#]).{8,}$") &&
               firstName.matches("^[A-ZÅÄÖa-zåäö]{1,20}$") &&
               lastName.matches("^[A-ZÅÄÖa-zåäö]{1,20}$") &&
               address.matches("^[A-ZÅÄÖa-zåäö0-9 .,-]{5,50}$") &&
               phone.matches("^\\+46\\d{7,9}$") &&
               balance.matches("^\\d+$");
    }

    public boolean authenticate(String username, String password){

        return false;
    }

    public void hashPassword(String password){

    }

    public double getBalance(String username){
        return users.get(username).getBalance();
    }

    public void updateBalance(String username, double NewBalance){
        users.get(username).setBalance(NewBalance);
    }

    public void logTransaction(String username, String type, double amount){

    }


}
