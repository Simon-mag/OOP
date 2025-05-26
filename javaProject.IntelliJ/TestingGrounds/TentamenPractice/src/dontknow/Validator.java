package dontknow;

public class Validator {
    public Validator() {}

    public boolean IsValidUsername(String username) {
        return username.matches("^[a-z][a-z0-9_-]{2,14}");
    }
}
