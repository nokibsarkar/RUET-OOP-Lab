import java.io.FileNotFoundException;
public class L01Throw {
    public static void main(String[] args){
        try{
            // throw the exception
            throw new FileNotFoundException("No File Found");
        } catch(FileNotFoundException e){
            System.out.println(e.getMessage());
        }
    }
}
