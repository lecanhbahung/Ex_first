package ALVTree;

public class Main {
    public static void main(String[] args) {
        AVLTree productTree = new AVLTree();

        productTree.addProduct(new Product(1, "Iphone 16 Pro Max", 800.00));
        productTree.addProduct(new Product(2, "Samsung S24 Ultra", 500.00));
        productTree.addProduct(new Product(3, "Apple Watch", 300.00));
        productTree.addProduct(new Product(4, "Ipad", 150.00));
        productTree.addProduct(new Product(5, "Nokia", 80.00));

        System.out.println("Duyệt cây theo thứ tự:");
        productTree.traverseInOrder();

        System.out.println("\nSản phẩm có giá cao nhất:");
        System.out.println(productTree.findHighestPrice());


        System.out.println("\nSản phẩm có giá thấp nhất:");
        System.out.println(productTree.findLowestPrice());


        productTree.removeProduct(3);
        System.out.println("\nSau khi xóa sản phẩm có ID 3:");
        productTree.traverseInOrder();
    }
}
