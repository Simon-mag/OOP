package UserInformation;

import java.io.*;
import java.util.Map;

//create methods that serialize in the users info into a .ser file
public class SerializeUser implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    public SerializeUser(){}

    public void serialize(Map<String, User> users){
        File file = new File("users.ser");
        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file))){
            out.writeObject(users);
            System.out.println("Successfully serialized into users.ser document");
        } catch (IOException e) {
            System.out.println("Serialization failed: " + e.getMessage());
        }
    }

}
