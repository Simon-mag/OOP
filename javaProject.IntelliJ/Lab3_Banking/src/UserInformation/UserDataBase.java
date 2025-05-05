package UserInformation;

import java.io.*;
import java.security.MessageDigest;
import java.util.*;

public class UserDataBase {

    private final Map<String, User> users = new HashMap<>();

    public UserDataBase(){}
    public UserDataBase(File inputFile){

        String line;
        try(Scanner reader = new Scanner(new FileReader(inputFile))) {

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
                    password = hashPassword(password);
                    updateBalance(username, Double.parseDouble(balance));

                    User user = new User(username, password, firstName, lastName, address, phone);
                    users.put(username, user);
                }else
                    throw new RuntimeException(username);
            }

        } catch (NumberFormatException e){
            System.out.println("Balance is in wrong format");
        } catch (RuntimeException e){
            System.out.print("User did not have valid formated information in \"users.txt\": " + e.getMessage());
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
               password.matches("^(?=.*[A-ZÅÄÖ])(?=.*\\d)(?=.*[!@#]).{8,}$") &&
               firstName.matches("^[A-ZÅÄÖa-zåäö]{1,20}$") &&
               lastName.matches("^[A-ZÅÄÖa-zåäö]{1,20}$") &&
               address.matches("^[A-ZÅÄÖa-zåäö0-9 .,-]{5,50}$") &&
               phone.matches("^\\+46\\d{7,9}$") &&
               balance.matches("^\\d+$");
    }

    public boolean authenticate(String username, String password){
        try {
            User user = loadUser(username);
            return (user != null) && user.getPassword().equals(hashPassword(password));
        } catch (RuntimeException e) {
            System.out.println("Could not load user: " + e.getMessage());
            return false;
        }
    }

    private String hashPassword(String password) throws RuntimeException{
        try{
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes());
            return Base64.getEncoder().encodeToString(hash);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public double getBalance(String username){
        File balances = new File("balances.txt");

        try(BufferedReader reader = new BufferedReader(new FileReader(balances))){
            String line;
            while ( (line = reader.readLine()) != null){
                String[] parts = line.trim().split(" +");
                if(parts[0].equals(username)){
                    return Double.parseDouble(parts[1]);
                }
            }
            System.out.println("User: " + username + " not found!");
        } catch (FileNotFoundException e) {
            System.out.println("could not open file: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        } catch (NumberFormatException e){
            System.out.println("Invalid balance format");
        }
        return 0;
    }

    public void updateBalance(String username, double newBalance){
        File balances = new File("balances.txt");
        List<String> userInfo = new ArrayList<>();
        boolean userFound = false;

        try(BufferedReader reader = new BufferedReader(new FileReader(balances))) {
            String line;
            while ( (line = reader.readLine()) != null){
                String[] parts = line.split(" ");

                if(parts[0].equals(username)){
                    userInfo.add(username + " " + newBalance);
                    userFound = true;
                }else
                    userInfo.add(line);
            }

        } catch (IOException e) {
            System.out.println("Error reading from balances.txt file!");
        }

        if(!userFound)
            userInfo.add(username + " " + newBalance);

        try(BufferedWriter writer = new BufferedWriter(new FileWriter(balances))){
            for(String updatedUserInfo : userInfo){
                writer.write(updatedUserInfo);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error writing to balances.txt file!");
            throw new RuntimeException(e);
        }

    }

    public void logTransaction(String username, String transactionType, double amount) throws IOException {
        try(Formatter formatter = new Formatter(new FileWriter("history_"+username+".log",true))){
        formatter.format("[%s] %s %.2f%n",new Date(), transactionType.toUpperCase(),amount);
        }
    }

    public User loadUser(String username) throws RuntimeException{
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream("users.ser"))){
            @SuppressWarnings("unchecked")
            Map<String,User> users = (Map<String, User>) in.readObject();
            return users.get(username);
        }catch (IOException | ClassNotFoundException e){
            System.out.println("failed to load user data: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public static void checkInputFile(){
        File inputFile = new File("users.txt");

        if(inputFile.exists()) {
            try {
                UserDataBase userDataBase = new UserDataBase(inputFile);
                new SerializeUser().serialize(userDataBase.getUsers());

                if (inputFile.delete()) {
                    System.out.println("InputFile deleted!");
                } else {
                    System.out.println("InputFile could not be deleted!");
                }
            } catch (Exception e) {
                System.out.println("Failed to initialize or serialize users");
                e.printStackTrace();
            }
        }
    }

    public Map<String,User> getUsers(){return users;}
}
