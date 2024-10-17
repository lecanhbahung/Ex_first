package SoLonNhatDeQuy;

public class demo {
    public static int soLonNhat(int arr[],int n){
        if(n==1){
            return arr[0];
        }else {
            int findnumber=soLonNhat(arr,n-1);
            return Math.max(arr[n-1],findnumber);
        }
    }

    public static void main(String[] args) {
        int arr[] ={65,13,27,19,6,34,52};
        int n=arr.length;
        System.out.println("Số lớn nhất của mảng là: "+soLonNhat(arr,n));
    }
}
