class Shape {
    protected int parentProperty = 0;
    public void test(){
        System.out.println("Drawing Shape");
    }
}
// Circle class inherits Shape class
// This is single inheritance from Shape to Circle
class Circle extends Shape {
    // override the test method
    public void test(){
        System.out.println("Accessing Parent property from Circle " + this.parentProperty);
    }
}
// Square class inherits Shape class
// This is single inheritance from Shape to Square
class Rectangle extends Shape {
    // override the test method
    public void test(){
        System.out.println("Accessing Parent property from Rectangle " + this.parentProperty);
    }
}
public class Shapery {
    public static void main(String[] args){
        // create an object of Shape
        Shape myShape = new Shape();
        // test the method
        myShape.test();
        // create an object of Circle
        Circle myCircle = new Circle();
        // test the method
        myCircle.test();
        // create an object of Rectangle
        Rectangle myRect = new Rectangle();
        // test the method
        myRect.test();
        // create an object of ImplementedClass
    }
}
