class Student implements Runnable {
    private String action;
    private int minutes;
    static int time = 0;
    Student(String action, int minutes){
        this.action = action;
        this.minutes = minutes;
    }
    private synchronized int updateTime(){
        time++;
        return time;
    }
    public void run(){
        for(int i = 1; i <= minutes; i++){
            System.out.println("Time " + updateTime() + "\t:\t" + Thread.currentThread().getName() + " is " + action + " for " + i + " minutes");
        }
    }
}
public class FourStudent {
    public static void main(String[] args) throws InterruptedException{
        Thread st1 = new Thread(new Student("reading", 30) ,"student1");
        Thread st2 = new Thread(new Student("writing", 10) ,"student2");
        Thread st3 = new Thread(new Student("playing", 20) ,"student3");
        Thread st4 = new Thread(new Student("gossiping", 10) ,"student4");
        // when st2 starts running no thread can interrupt untill st2 is finished
        // the same goes for st3
        // implement this with priority
        st2.setPriority(Thread.MAX_PRIORITY);
        st3.setPriority(Thread.MAX_PRIORITY);
        st1.setPriority(1);
        st4.setPriority(1);
        st1.start();
        st2.start();
        st2.join();
        st3.start();
        st3.join();
        st4.start();
    }
}
