package UserInformation;

import java.io.*;
import java.util.Map;
import java.util.Objects;

//create methods that serialize in the users info into a .ser file
public class SerializeUser implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    public SerializeUser(){}

    public void serialize(Map<String, User> users){
        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("users.ser"))){
            out.writeObject(users);
            System.out.println("Successfully serialized into users.ser document");
        } catch (IOException e) {
            System.out.println("Serialization failed: " + e.getMessage());
        }
    }
    public void deSerialize(){

    }

}
