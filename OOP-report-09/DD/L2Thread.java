class Thread1 extends Thread{
    public String name;
    public  String work;
    public int duration;
    Thread1(String name, String work, int duration){
      this.name = name;
      this.work = work;
      this.duration = duration;
    }
    public void run (){
        for(int i = 0; i <= duration; i++){
        System.out.println(this.name +" is "+ this.work+ " for " + i + " minutes.");
       }
    }   
}
public class L2Thread {
    public static void main(String[] args) {

        Thread1 t1 = new Thread1("S1","reading",30);
        Thread1 t2 = new Thread1("S2","writing",10);
        Thread1 t3 = new Thread1("S3","playing",20);
        Thread1 t4 = new Thread1("S4","gossiping",10);


        t1.start();

        t2.setPriority(10);
        t2.start();

        
        t3.start();
        t4.start();
        
    }
}