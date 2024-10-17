package StudentBinarySearch;

public class Student {
    String studentID;
    String name;
    double score;

    public Student(String studentID, String name, double score) {
        this.studentID = studentID;
        this.name = name;
        this.score = score;
    }

    public String toString() {
        return "ID: " + studentID + ", Name: " + name + ", Score: " + score;
    }
}
