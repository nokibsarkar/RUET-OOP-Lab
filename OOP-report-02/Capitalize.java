import java.util.Scanner;
public class Capitalize {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        sc.close();
        String[] words = str.split(" ");
        String capitalize = "";
        for (String w : words) {
            String first = w.substring(0, 1);
            String afterfirst = w.substring(1);
            capitalize += first.toUpperCase() + afterfirst + " ";
        }
        System.out.println(capitalize);
    }
}
