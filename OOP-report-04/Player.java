/**
 * Player
 */
import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;
public class Player {
    private String name;
    private int age;
    private String country;
    private int match = 0;
    private int goals = 0;
    private int distance = 0;
    private int min_played = 0;
    
    public void add_match(int goal, int min_played,  int distance){
        match++;
        goals += goal;
        this.distance += distance;
        this.min_played += min_played;
    }
    public float get_goal_per_match(){
        if(match == 0)
            return 0;
        else
            return (float) goals / match;
    }
    public float get_speed(){
        if(min_played == 0)
            return 0;
        else
            return  (float) distance / min_played;
    }
    Player(){

    }
    Player(String name, int age, String country){
        this.name = name;
        this.age = age;
        this.country = country;
    }
    public void show_stat(){
        System.out.println("\tName\t:\t" + name);
        System.out.println("\tAge\t:\t" + age);
        System.out.println("\tCountry\t:\t" + country);
        System.out.println("\n\t-------------Statistics----------");
        System.out.println("\tTotal Goals\t:\t" + goals);
        System.out.println("\tGoal per match\t:\t" + get_goal_per_match());
        System.out.println("A\tvg speed\t:\t" + get_speed());
        System.out.println("\t--------------End------------");
    }
    public static void main(String[] args){
        System.out.print("Enter number : ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        Player[] players = new Player[n];
        for(int i = 0; i < n; i++){
            System.out.print("Enter the new player's Name : ");
            String name = sc.nextLine();
            System.out.print("Enter the new player's age : ");
            int age = sc.nextInt();
            sc.nextLine();
            System.out.print("Enter the new player's country : ");
            String country = sc.nextLine();
            System.out.println("Country :" + country);
            players[i] = new Player(name, age, country);
            System.out.println("Added");
            int choice = 1;
            while(choice == 1){
                System.out.println("Do you want to add match? 1 =yes, 0=no");
                choice = sc.nextInt();
                if(choice == 0)
                    break;
                System.out.print("Enter the goals : ");
                int goal = sc.nextInt();
                System.out.print("Enter the distance : ");
                int distance = sc.nextInt();
                System.out.print("Enter the minutes played : ");
                int min_played = sc.nextInt();
                players[i].add_match(goal, min_played, distance);
            }
            players[i].show_stat();
        }
        sc.close();
        Arrays.sort(players, Comparator.comparing(Player::get_goal_per_match).reversed());
        for(int i = 0; i < n; i++){
            players[i].show_stat();
        }
        Player top_speed = new Player(),
        best_striker = players[0];
        for(int i = 0; i < players.length; i++){
            if(top_speed.get_speed() < players[i].get_speed())
                top_speed = players[i];
        }
        System.out.println("----------------Top Speedy player -------");
        top_speed.show_stat();
        System.out.println("\n--------------Best Striker--------------");
        best_striker.show_stat();
        
        
    }

}