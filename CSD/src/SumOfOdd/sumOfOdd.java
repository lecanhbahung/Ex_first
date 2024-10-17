package SumOfOdd;

public class sumOfOdd {
    public static int sumOdd(int n){
        if (n==0){
            return 0;
        }else {
            return (2*n-1)+sumOdd(n-1);
        }
    }

    public static void main(String[] args) {
        System.out.println(sumOdd(7));
    }
}
