public class L02PropUnChecked {
    // method to generate unchecked exception
    public static void generateException(){
        int k = 0/0; // throw the ArithmeticException
    }
    public static void midException() {
        // middleware method to pass the exception
        generateException();
    }
    public static void main(String[] args){
        try { /*
            call the middleware method
            which will pass the exception to this
            which was generated in the middleware method generateException()
            */
            midException();
        } catch (ArithmeticException e) {
            System.out.println("Propagated from generateException()");
            System.out.println(e.getMessage());
        }
    } 
}
