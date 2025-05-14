





public class Main {
    public static void main(String[] args) {
        Registry<Student> students = new Registry<>();
        Registry<Teacher> teachers = new Registry<>();

        students.addItem(new Student("Simon"));
        students.addItem(new Student("Axel"));
        students.addItem(new Student("Elias"));
        students.addItem(new Student("Carl"));
        students.addItem(new Student("Felix"));
        students.addItem(new Student("Daniel"));

        teachers.addItem(new Teacher("Ragnar"));
        teachers.addItem(new Teacher("Johan"));
        teachers.addItem(new Teacher("Görkem"));
        teachers.addItem(new Teacher("Arpan"));
        teachers.addItem(new Teacher("Mikel"));
        teachers.addItem(new Teacher("Åsa"));

        students.listItems();
        teachers.listItems();

        students.sortItems();
        students.listItems();
        teachers.sortItems();
        teachers.listItems();

        students.sortItems();
        students.listItems();
        teachers.sortItems();
        teachers.listItems();

        students.countByInitial();
        students.listItems();
        teachers.countByInitial();
        teachers.listItems();

        students.removeItem("Carl");
        teachers.removeItem();
}