package Stack;

import java.util.Scanner;
import java.util.Stack;

public class demo {
    public static String reseverString(String input){
        Stack<Character> stack=new Stack<>();
        for (int i=0;i<input.length();i++){
            stack.push(input.charAt(i));
        }
        StringBuilder sb=new StringBuilder();
        while (!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Nhập vào chuỗi: ");
        String a=scanner.nextLine();
        System.out.println(reseverString(a));
    }
}
