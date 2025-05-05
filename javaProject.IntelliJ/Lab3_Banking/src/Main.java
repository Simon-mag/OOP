import BankInteraction.BankLogIn;

import static UserInformation.UserDataBase.checkInputFile;

public class Main {
    public static void main(String[] args) {
        checkInputFile();
        new BankLogIn();
    }
}