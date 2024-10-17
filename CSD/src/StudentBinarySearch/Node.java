package StudentBinarySearch;

public class Node {
    Student student;
    Node left, right;

    public Node(Student student) {
        this.student = student;
        this.left = this.right = null;
    }
}
