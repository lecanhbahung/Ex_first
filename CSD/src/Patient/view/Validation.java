package Patient.view;

import java.util.Scanner;

public class Validation {
    public static String getValue(String input){
        Scanner scanner=new Scanner(System.in);
        System.out.println(input);
        return scanner.nextLine();
    }
}
