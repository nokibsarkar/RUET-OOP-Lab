import java.util.Scanner;

class MyThread extends Thread {
    // 
    public void run(){
        System.out.println(this.getStackTrace());
        try {
            MyThread.sleep(MAX_PRIORITY);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(this.getName() + this.getState());
    }
}
public class Multiprocessing {
    public static void main(String[] args) throws InterruptedException{
        Thread mt = new Thread("lame");
        System.out.print(mt);
        System.out.println(mt.getPriority());
        mt.start();
        MyThread mt2 = new MyThread();
        System.out.print(mt2);
        System.out.println(mt2.getName() + mt2.getState());
        mt2.start();
        System.out.println(mt.getName() + mt.getState());
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
        sc.close();

        MyThread.sleep(MyThread.MAX_PRIORITY);
        System.out.println(mt2.getName() + mt2.getState());
        mt2.join();
        mt.join();

        System.out.println(mt2.getName() + mt2.getState());
    }
}