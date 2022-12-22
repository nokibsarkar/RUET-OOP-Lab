import java.io.FileNotFoundException;
public class L03PropChecked {
    public static void generateException() throws FileNotFoundException{
        // throw the checked exception
        throw new FileNotFoundException("from generateException()");
    }
    public static void midMethod() throws FileNotFoundException {
        // middleware method to propagate the exception
        generateException();
    }
    public static void main(String[] args) {
        try {/*
             * call the middleware method which will pass the exception to this method
             * which was generated in the middleware method generateException()
             */
            midMethod();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
