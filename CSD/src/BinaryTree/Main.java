package BinaryTree;

public class Main {
    public static void main(String[] args) {
        BinaryTree binaryTree=new BinaryTree();
        int[] values={80,20,30,70,40,90,10};

        for(int temp:values){
            binaryTree.insert(temp);
        }
        binaryTree.levelOrder();
        binaryTree.preOrder();
        binaryTree.inOder();
        binaryTree.postOrder();

        System.out.println("Tìm 40: " + binaryTree.search(10)); // Kết quả: true
        System.out.println("Tìm 90: " + binaryTree.search(80)); // Kết quả: false

        // Tính chiều cao của cây nhị phân
        System.out.println("Chiều cao của cây: " + binaryTree.height());
    }
}
