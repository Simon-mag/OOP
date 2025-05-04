
import BankInteraction.BankLogIn;
import BankInteraction.BankUI;
import UserInformation.SerializeUser;
import UserInformation.User;
import UserInformation.UserDataBase;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        BankUI bankUI = new BankUI();
        SerializeUser serializeUser = new SerializeUser();
        UserDataBase userDataBase;

        File inputFile = new File("users.txt");
        if(inputFile.exists()) {
            userDataBase = new UserDataBase();
            serializeUser.serialize(userDataBase.getUsers());

        }
        if(inputFile.delete())
            System.out.println("InputFile deleted!");
        else
            System.out.println("InputFile could not be deleted!");


        //BankLogIn bankLogIn = new BankLogIn();
    }
}