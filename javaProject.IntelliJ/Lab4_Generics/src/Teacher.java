public class Teacher extends Person{
    private static int nextId = 2000;

    public Teacher(String name){ super(name, "Teacher", nextId++); }
}
