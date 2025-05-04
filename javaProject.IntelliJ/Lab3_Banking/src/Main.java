
import BankInteraction.BankLogIn;
import BankInteraction.BankUI;
import UserInformation.SerializeUser;
import UserInformation.User;
import UserInformation.UserDataBase;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        File inputFile = new File("users.txt");

        if(inputFile.exists()) {
            try {
                UserDataBase userDataBase = new UserDataBase(inputFile);
                SerializeUser serializeUser = new SerializeUser();

                serializeUser.serialize(userDataBase.getUsers());

                if (inputFile.delete()) {
                    System.out.println("InputFile deleted!");
                } else {
                    System.out.println("InputFile could not be deleted!");
                }
            } catch (Exception e) {
                System.out.println("Failed to initialize or serialize users");
                e.printStackTrace();
                return;
            }
        }


        new BankLogIn();
    }
}