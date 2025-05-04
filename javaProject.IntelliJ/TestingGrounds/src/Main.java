
import java.util.Scanner;



public class Main {
    public static void main(String[] args) {

        Scanner x = new Scanner(System.in);
        if(validateUserInfo(
                "nomis570",
                "Password123!",
                "Simon",
                "Magnusson",
                "Sverige gatan 3",
                "+46782132436",
                "2000"))
            System.out.println("These are valid entries");
        else
            System.out.println("Something was invalid");


    }

    private static boolean validateUserInfo(
            String username,
            String password,
            String firstName,
            String lastName,
            String address,
            String phone,
            String balance)
    {
        return username.matches("^[A-Za-z][A-Za-z0-9_]{4,11}$") &&
                password.matches("^(?=.*[A-ZÅÄÖ])(?=.*\\d)(?=.*[!@#]).{8,}$") &&
                firstName.matches("^[A-ZÅÄÖa-zåäö]{1,20}$") &&
                lastName.matches("^[A-ZÅÄÖa-zåäö]{1,20}$") &&
                address.matches("^[A-ZÅÄÖa-zåäö0-9 .,-]{5,50}$") &&
                phone.matches("^\\+46\\d{7,9}$") &&
                balance.matches("^\\d+$");
    }


}