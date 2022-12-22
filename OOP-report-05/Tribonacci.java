import java.math.BigInteger;
public class Tribonacci {
    public static void main(String[] args){
        BigInteger[] arr = new BigInteger[1000];
        arr[0] = BigInteger.valueOf(0);
        arr[1] = BigInteger.valueOf(0);
        arr[2] = BigInteger.valueOf(1);
        for(int i = 3; i < 1000; i++)
            arr[i] = arr[i-1].add(arr[i-2]).add(arr[i-3]);
        for(int i = 0; i < 20; i++){
            System.out.println(arr[i]);
        }
    }
}