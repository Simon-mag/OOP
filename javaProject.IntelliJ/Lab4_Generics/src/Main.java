import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Registry<Student> students = new Registry<>();
        Registry<Teacher> teachers = new Registry<>();

        students.addItem(new Student("Simon"));
        Student axel = new Student("Axel");
        students.addItem(new Student("Elias"));
        students.addItem(new Student("Carl"));
        students.addItem(new Student("Felix"));
        students.addItem(new Student("daniel"));
        students.addItem(axel);

        teachers.addItem(new Teacher("Ragnar"));
        Teacher johan = new Teacher("Johan");
        teachers.addItem(new Teacher("Görkem"));
        teachers.addItem(new Teacher("Arpan"));
        teachers.addItem(new Teacher("Mikel"));
        teachers.addItem(new Teacher("Åsa"));
        teachers.addItem(johan);

        System.out.println("Students: \n");
        students.listItems();
        delay();
        System.out.println("Teachers: \n");
        teachers.listItems();
        delay();

        System.out.println("Students sorted by ID: \n");
        students.sortItems();
        students.listItems();
        delay();
        System.out.println("Teachers sorted by ID: \n");
        teachers.sortItems();
        teachers.listItems();
        delay();

        System.out.println("Students sorted by initials: \n");
        students.sortItems(Comparator.comparing(p->p.getName().toLowerCase()));
        students.listItems();
        delay();
        System.out.println("Teachers sorted by initials: \n");
        teachers.sortItems(Comparator.comparing(p->p.getName().toLowerCase()));
        teachers.listItems();
        delay();

        System.out.println("Students grouped by initials: \n");
        students.countByInitial();
        delay();
        System.out.println("Teachers grouped by initials: \n");
        teachers.countByInitial();
        delay();

        System.out.println("Removing some students and teachers... \n");
        delay();
        System.out.println("Students after removal: \n");
        students.removeItem(axel);
        students.removeItem(students.registry.getFirst());
        students.listItems();
        delay();

        System.out.println("Teachers after removal: \n");
        teachers.removeItem(johan);
        teachers.removeItem(teachers.registry.getLast());
        teachers.listItems();
        delay();
    }

    public static void delay(){
        try {
            Thread.sleep(900);
        } catch(InterruptedException e) {
            throw new RuntimeException(e);}
    }
}
