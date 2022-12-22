public class MyException extends Exception {
    int status = 0;
    public MyException(int status){
        this.status = status;
    }
    public String getMessage(){
        return "This is my Custom Exception. Status : " + status;
    }
    public String toString(){
        return "<My Exception status=" + status + ">";
    }
    public static void  main(String[] args) {
        try {
            throw new MyException(0);
        } catch (MyException e){
            System.out.println("MyException Happened " + e.getMessage());
        }
        
    }
}
