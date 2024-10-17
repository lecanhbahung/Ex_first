package StudentBinarySearch;

public class Main {
    public static void main(String[] args) {
        SearchBinary bst = new SearchBinary();

        // Thêm sinh viên vào cây
        bst.insert(new Student("001", "Ba Hung", 87.0));
        bst.insert(new Student("002", "Le Canh", 91.5));
        bst.insert(new Student("003", "Nguyen An", 60.0));
        bst.insert(new Student("004", "Nam Nguyen", 87.0));

        // Duyệt cây theo In-order và in danh sách sinh viên
        System.out.println("In-order Traversal:");
        bst.traverseInOrder();

        // Tìm kiếm sinh viên theo ID
        String searchID = "002";
        Student foundStudent = bst.search(searchID);
        System.out.println("\nSearch result for ID " + searchID + ":");
        if (foundStudent != null) {
            System.out.println(foundStudent);
        } else {
            System.out.println("Student not found.");
        }

        // Xóa sinh viên khỏi cây và duyệt lại
        String deleteID = "003";
        System.out.println("\nDeleting student with ID " + deleteID);
        bst.delete(deleteID);
        System.out.println("In-order Traversal after deletion:");
        bst.traverseInOrder();

        // Tìm sinh viên có điểm cao nhất
        System.out.println("\nStudent with the highest score:");
        Student maxScoreStudent = bst.findMaxScore();
        if (maxScoreStudent != null) {
            System.out.println(maxScoreStudent);
        }
    }
}
