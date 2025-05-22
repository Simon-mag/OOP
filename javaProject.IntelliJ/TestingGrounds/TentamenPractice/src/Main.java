
public class Main {
    public static void main(String[] args) {
        Validator validator = new Validator();
        validator.IsValidUsername("simon--"); // Valid
        validator.IsValidUsername("Simon--"); // Invalid
        validator.IsValidUsername("simon--__911"); // Valid
        validator.IsValidUsername("åland##"); // Invalid

    }
}
