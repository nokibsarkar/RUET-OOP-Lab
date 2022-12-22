import java.util.Scanner;
// custom exception class
class MinorException extends Exception {
    private int age;
    // overloaded constructor to accept the age
    MinorException(int age){
        this.age = age;
    }
    // override the toString() method to return the message
    public String getMessage(){
        return "The Age " + age + " is less than voting age 18";
    }
}
public class L04CustomException {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        try{
            System.out.print("Enter the age :");
            int age = sc.nextInt();
            // throw the exception if age is less than 18
            if( age < 18)
                throw new MinorException(age);
            // else print the age
            System.out.println("The age is " + age);
            System.out.println("The user is allowed to vote");
        } catch(MinorException e){
            // print the message from the exception
            System.out.println(e.getMessage());
        }
         finally {
            // close the scanner
            sc.close();
        }
    }
}
