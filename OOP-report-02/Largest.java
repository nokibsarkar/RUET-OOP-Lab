/* Java program to find the largest word in a given string and print that word */
import java.util.Scanner;
public class Largest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        sc.close();
        String[] words = str.split(" ");
        String largest = "";
        for (String w : words) {
            if (w.length() > largest.length()) {
                largest = w;
            }
        }
        System.out.println(largest);
    }
}
