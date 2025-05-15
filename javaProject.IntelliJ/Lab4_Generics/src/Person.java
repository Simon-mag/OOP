public abstract class Person implements Comparable<Person> {
    private String name;
    private final String role;
    protected int id;

    public Person(String name, String role,int id){
        this.name = name;
        this.role = role;
        this.id = id;
    }
    @Override
    public int compareTo(Person o){
        return Integer.compare(this.id, o.id);
    }

    @Override
    public String toString(){
        return role + " - " + id + ": " + name + "\n";
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj)
            return true;
        if(obj == null || getClass() != obj.getClass())
            return false;
        Person other = (Person) obj;
        return id == other.id && name.equals(other.name) && role.equals(other.role);
    }


    public String getName(){return name;}
    public String getRole(){return role;}
    public int getID() {return id;}

    public void setName(String name){this.name = name;}
}
