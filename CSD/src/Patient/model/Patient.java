package Patient.model;

public class Patient {
    private String name;
    private int age;

    public Patient(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
    public void display(){
        System.out.printf("%-10s %-10d%n",name,age);
    }
}
