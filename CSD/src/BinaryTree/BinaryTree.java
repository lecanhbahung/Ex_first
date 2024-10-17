package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    Node root;

    public BinaryTree() {
        root=null;
    }
    public Node insertRec(Node root,int value){
        if(root==null){
            root=new Node(value);
            return root;
        }
        if(value<root.value){
            root.left=insertRec(root.left,value);
        }else {
            root.right=insertRec(root.right,value);
        }
        return root;
    }
    public void insert(int value){
        root=insertRec(root,value);
    }
    public void levelOrder(){
        System.out.println("Level Order: ");
        if (root==null){
            return;
        }
        Queue<Node> nodeQueue=new LinkedList<>();
        nodeQueue.add(root);
        while (!nodeQueue.isEmpty()){
            Node temp=nodeQueue.poll();
            System.out.println(temp.value);
            if(temp.left!=null){
                nodeQueue.add(temp.left);
            }
            if(temp.right!=null){
                nodeQueue.add(temp.right);
            }
        }
        System.out.println();
    }
    public void preOrderRe(Node root){
        if (root!=null) {
            System.out.println(root.value+"");
            preOrderRe(root.left);
            preOrderRe(root.right);
        }
    }
    public void preOrder(){
        System.out.println("PreOder: ");
        preOrderRe(root);
        System.out.println();
    }
    public void inOrderRe(Node root){
        if (root!=null){
            inOrderRe(root.left);
            System.out.println(root.value+"");
            inOrderRe(root.right);
        }
    }
    public void inOder(){
        System.out.println("InOrder: ");
        inOrderRe(root);
        System.out.println();
    }
    public void postOrderRe(Node root){
        if (root!=null){
            postOrderRe(root.left);
            postOrderRe(root.right);
            System.out.println(root.value+"");
        }
    }
    public void postOrder(){
        System.out.println("PostOrder: ");
        postOrderRe(root);
        System.out.println();
    }
    public Node searchRe(Node root,int value){
        if (root==null||root.value==value){
            return root;
        }
        if (root.value>value){
            return searchRe(root.left,value);
        }
        return searchRe(root.right,value);
    }
    public boolean search(int value){
        return searchRe(root,value)!=null;
    }
    public int heightRec(Node root){
        if (root!=null){
            return 0;
        }
        int leftOfHeight=heightRec(root.left);
        int rightOfHeight=heightRec(root.right);
        return  Math.max(leftOfHeight,rightOfHeight)+1;
    }
    public int height(){
        return heightRec(root);
    }
}
