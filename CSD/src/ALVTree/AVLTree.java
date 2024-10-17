package ALVTree;

public class AVLTree {
    private AVLNode root;

    // Lấy chiều cao của nút
    private int getHeight(AVLNode node) {
        return node == null ? 0 : node.height;
    }

    // Tính hệ số cân bằng
    private int getBalance(AVLNode node) {
        return node == null ? 0 : getHeight(node.left) - getHeight(node.right);
    }

    // Phép xoay phải
    private AVLNode rotateRight(AVLNode y) {
        AVLNode x = y.left;
        AVLNode T2 = x.right;

        x.right = y;
        y.left = T2;

        y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;
        x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;

        return x;
    }

    // Phép xoay trái
    private AVLNode rotateLeft(AVLNode x) {
        AVLNode y = x.right;
        AVLNode T2 = y.left;

        y.left = x;
        x.right = T2;

        x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;
        y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;

        return y;
    }

    // Thêm sản phẩm
    public void addProduct(Product product) {
        root = addRec(root, product);
    }

    private AVLNode addRec(AVLNode node, Product product) {
        if (node == null) {
            return new AVLNode(product);
        }

        if (product.getId() < node.product.getId()) {
            node.left = addRec(node.left, product);
        } else if (product.getId() > node.product.getId()) {
            node.right = addRec(node.right, product);
        } else {
            return node; // Không cho phép ID trùng lặp
        }

        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
        int balance = getBalance(node);

        // Cân bằng cây
        if (balance > 1 && product.getId() < node.left.product.getId()) {
            return rotateRight(node);
        }

        if (balance < -1 && product.getId() > node.right.product.getId()) {
            return rotateLeft(node);
        }

        if (balance > 1 && product.getId() > node.left.product.getId()) {
            node.left = rotateLeft(node.left);
            return rotateRight(node);
        }

        if (balance < -1 && product.getId() < node.right.product.getId()) {
            node.right = rotateRight(node.right);
            return rotateLeft(node);
        }

        return node;
    }

    // Xóa sản phẩm
    public void removeProduct(int id) {
        root = removeRec(root, id);
    }

    private AVLNode removeRec(AVLNode node, int id) {
        if (node == null) {
            return node;
        }

        if (id < node.product.getId()) {
            node.left = removeRec(node.left, id);
        } else if (id > node.product.getId()) {
            node.right = removeRec(node.right, id);
        } else {
            // Nút này là nút cần xóa
            if (node.left == null || node.right == null) {
                AVLNode temp = (node.left != null) ? node.left : node.right;
                if (temp == null) {
                    return null; // Nút không có con
                } else {
                    return temp; // Nút chỉ có một con
                }
            } else {
                // Nút có hai con, tìm giá trị nhỏ nhất trong cây con bên phải
                AVLNode temp = findMin(node.right);
                node.product = temp.product;
                node.right = removeRec(node.right, temp.product.getId());
            }
        }

        if (node == null) {
            return node;
        }

        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
        int balance = getBalance(node);

        // Cân bằng cây
        if (balance > 1 && getBalance(node.left) >= 0) {
            return rotateRight(node);
        }

        if (balance < -1 && getBalance(node.right) <= 0) {
            return rotateLeft(node);
        }

        if (balance > 1 && getBalance(node.left) < 0) {
            node.left = rotateLeft(node.left);
            return rotateRight(node);
        }

        if (balance < -1 && getBalance(node.right) > 0) {
            node.right = rotateRight(node.right);
            return rotateLeft(node);
        }

        return node;
    }

    private AVLNode findMin(AVLNode node) {
        AVLNode current = node;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }

    // Duyệt cây theo thứ tự
    public void traverseInOrder() {
        traverseRec(root);
    }

    private void traverseRec(AVLNode node) {
        if (node != null) {
            traverseRec(node.left);
            System.out.println(node.product);
            traverseRec(node.right);
        }
    }

    // Tìm sản phẩm có giá cao nhất
    public Product findHighestPrice() {
        if (root == null) return null;
        return findMaxValue(root);
    }

    private Product findMaxValue(AVLNode node) {
        while (node.right != null) {
            node = node.right;
        }
        return node.product;
    }

    // Tìm sản phẩm có giá thấp nhất
    public Product findLowestPrice() {
        if (root == null) return null;
        return findMinValue(root);
    }

    private Product findMinValue(AVLNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node.product;
    }
}
