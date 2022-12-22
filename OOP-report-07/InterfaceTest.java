/*
 * A derived class that implements the interface must implement all the methods
 * Otherwise, it must be declared abstract
 */
interface MustImplement {
    public void main1();
}
interface MustImplement2 {
    public void main2();
}
class ImplementedClass implements MustImplement, MustImplement2{
    // implement the abstract method from the interface MustImplement
    public void main1(){
        System.out.println("implemented Main1 from the first");
    }
    // implement the abstract method from the interface MustImplement2
    public void main2(){
        System.out.println("implemented Main2 from second ");
    }
    public void main(){
        // method to test the functions
        main1();
        main2();
    }
}
public class InterfaceTest {
    public static void main(String[] args) {
        // create an object of ImplementedClass
        ImplementedClass myi = new ImplementedClass();
        // test the method
        myi.main(); 
    }
}
