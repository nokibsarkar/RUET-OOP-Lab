import java.util.Random;
import java.util.Scanner;

class Reserve implements Runnable {
    private static int passengerID = 1;
    private static Random rn = new Random();
    public void run(){
        System.out.println("Please Enter your name");
        // random name
        String name = "passenger-" + Reserve.passengerID;
        Reserve.passengerID++;
        System.out.println("Enter number of tickets you want to buy? :");
        int tickets = 1 + rn.nextInt(1 + BusReservation.availableTicket);
        reserve(name, tickets);
    }
    private static synchronized void reserve(String name, int tickets){
        // it is synchronized because we are accessing the shared resource
        if(BusReservation.availableTicket < tickets){
            System.out.println("Reservation failed for " + name);
        } else {
            BusReservation.availableTicket -= tickets;
            System.out.println("Reservation successful\n\tuser: " + name + "\n\tTickets : " + tickets + "\n\tAvailable Tickets : " + BusReservation.availableTicket);
        }
    }
}
public class BusReservation {
    public static int availableTicket = 100;
    public static void main(String[] args) throws InterruptedException{
        Scanner sc = new Scanner(System.in);
        String conf = "y";
        while(conf.equals("y")){
            System.out.println("Do you want to reserve a ticket? [y/n]");
            conf = sc.nextLine();
            if(conf.equals("y")){
                Thread th = new Thread(new Reserve());
                th.start();
                th.join();
            }
        }
        sc.close();
    }
}
