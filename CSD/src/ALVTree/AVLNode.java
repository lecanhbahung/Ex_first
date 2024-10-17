package ALVTree;

public class AVLNode {
    Product product;
    AVLNode left, right;
    int height;

    public AVLNode(Product product) {
        this.product = product;
        this.height = 1; // Chiều cao của nút mới là 1
    }
}
