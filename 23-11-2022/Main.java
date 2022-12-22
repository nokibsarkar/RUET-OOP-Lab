import java.util.Scanner;

public class Main{
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        try {
            int s ;
            s = sc.nextInt();
            if(s == -1)
                s = ~(1 << 31);
            int[] k = new int[s];
            System.out.println(6 ^ 4);
            
        } catch(ArithmeticException e){
            System.out.println("Arithmetic");
            System.out.print(e);
        }
         catch(Error e){
            StackTraceElement[] a = e.getStackTrace();
            System.out.print(a[0]);
            // throw e;
        } finally{
            sc.close();
        }
    }
}