import java.util.Scanner;
public class Finally {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Scanner Opened");
        try {
            int k = 0 / 0; // throws an ArithmeticException
            int[] a = new int[10]; // throws an ArrayIndexOutOfBoundsException
            System.out.println(a[10]);
        } catch (ArithmeticException e) {
            // handle the ArithmeticException
            System.out.println("Error Happened");
            System.out.println(e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e) {
            // handle the ArrayIndexOutOfBoundsException
            System.out.println("Indexing out of bound");
        } finally {
            // Perform this block of code irrespective of the exception
            System.out.println("Closing the scanner");
            sc.close();
        }
        System.out.println("Rest of the code in nested");

        System.out.println("Rest of the code");
    }
}
