public class Student extends Person{
    private static int nextId = 1000;

    public Student(){
        super("Noname", "Student", nextId++);
    }
    public Student(String name){
        super(name, "Student" , nextId++);
    }
}
