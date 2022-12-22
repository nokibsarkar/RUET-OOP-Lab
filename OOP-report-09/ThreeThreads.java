import java.util.Scanner;
class Task1 implements Runnable {
    public void run(){
        System.out.println("Task1 : Enter the input for  task1" );
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        sc.close();
        for(int j = 0; j < 200; j++){
            System.out.println("Task 1: User input number is " + i);
        }
        
    }
}
class Task2 implements Runnable {
    public void run(){
        for(int i = 0; i < 200; i++){
            System.out.println("Task 2: Some string");
        }
    }
}
class Task3 implements Runnable {
    public void run(){
        int sum = 0;
        for(int i = 10; i <= 200; i++){
            sum += i;
            System.out.println("Task 3: Temporary sum upto " + i + " is " + sum);
        }
    }
}
public class ThreeThreads {
    public static void main(String[] ag) throws InterruptedException{
        Thread mt = new Thread(new Task1(), "task1");
        Thread mt2 = new Thread(new Task2(), "task2");
        Thread mt3 = new Thread(new Task3(), "task3");
        mt.start();
        mt2.start();
        mt3.start();
        mt.join();
        mt2.join();
        mt3.join();

    }
}