import java.util.Scanner;
public class Nested {
    public static void main(String[] args) {
        try {
            int k = 0 / 0; // It would throw an ArithmeticException
            Scanner sc = new Scanner(System.in);
            System.out.println("Scanner Opened");
            try {
                int[] a = new int[10];
                System.out.println(a[10]); // It would throw an ArrayIndexOutOfBoundsException
            } catch (ArithmeticException e) {
                // This block would handle the ArithmeticException
                System.out.println("Error Happened");
                System.out.println(e.getMessage());
            } catch (ArrayIndexOutOfBoundsException e) {
                // This block would handle the ArrayIndexOutOfBoundsException
                System.out.println("Indexing out of bound");
            }
            sc.close(); // Closing the scanner
            System.out.println("Rest of the code in nested");
        } catch (Exception e) {
            // This block would handle the other exceptions
            System.out.println("Scanner could not be opened");
        }
        System.out.println("Rest of the code");
    }
}
