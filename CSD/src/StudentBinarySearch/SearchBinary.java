package StudentBinarySearch;

public class SearchBinary {
    Node root;

    public SearchBinary() {
        this.root = null;
    }

    // Phương thức chèn sinh viên vào cây
    public void insert(Student student) {
        root = insertRec(root, student);
    }

    private Node insertRec(Node root,Student student){
        if (root==null){
            root=new Node(student);
            return root;
        }
        if(student.studentID.compareTo(root.student.studentID)<0){
            root.left=insertRec(root.left,student);
        } else if (student.studentID.compareTo(root.student.studentID)>0) {
            root.right=insertRec(root.right,student);
        }
        return root;
    }

    // Phương thức duyệt cây theo In-order
    public void traverseInOrder() {
        traverseInOrderRec(root);
    }

    private void traverseInOrderRec(Node root) {
        if (root != null) {
            traverseInOrderRec(root.left);
            System.out.println(root.student);
            traverseInOrderRec(root.right);
        }
    }

    // Phương thức tìm kiếm sinh viên theo ID
    public Student search(String studentID) {
        Node result = searchRec(root, studentID);
        return result != null ? result.student : null;
    }

    private Node searchRec(Node root, String studentID) {
        if (root == null || root.student.studentID.equals(studentID)) {
            return root;
        }
        if (studentID.compareTo(root.student.studentID) < 0) {
            return searchRec(root.left, studentID);
        }
        return searchRec(root.right, studentID);
    }

    // Phương thức xóa sinh viên theo ID
    public void delete(String studentID) {
        root = deleteRec(root, studentID);
    }

    private Node deleteRec(Node root, String studentID) {
        if (root == null) return root;

        if (studentID.compareTo(root.student.studentID) < 0) {
            root.left = deleteRec(root.left, studentID);
        } else if (studentID.compareTo(root.student.studentID) > 0) {
            root.right = deleteRec(root.right, studentID);
        } else {
            // Node có một hoặc không có con
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;

            // Node có hai con, tìm node nhỏ nhất ở cây con bên phải
            root.student = findMin(root.right).student;

            // Xóa node nhỏ nhất ở cây con bên phải
            root.right = deleteRec(root.right, root.student.studentID);
        }
        return root;
    }

    private Node findMin(Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    // Phương thức tìm sinh viên có điểm cao nhất
    public Student findMaxScore() {
        if (root == null) return null;
        return findMaxScoreRec(root, root.student);
    }

    private Student findMaxScoreRec(Node root, Student maxStudent) {
        if (root != null) {
            if (root.student.score > maxStudent.score) {
                maxStudent = root.student;
            }
            maxStudent = findMaxScoreRec(root.left, maxStudent);
            maxStudent = findMaxScoreRec(root.right, maxStudent);
        }
        return maxStudent;
    }
}
