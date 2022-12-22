class GeoShape {
    protected int cx;
    public int getCx() {
        return cx;
    }
    public void setCx(int cx) {
        this.cx = cx;
    }
    protected int cy;
    public int getCy() {
        return cy;
    }
    public void setCy(int cy) {
        this.cy = cy;
    }
}
class Quad extends GeoShape_ {
    protected float diagonal;
    public float getDiagonal() {
        return diagonal;
    }
    public void setDiagonal(float diagonal) {
        this.diagonal = diagonal;
    }
    
}
public class Rectangle extends Quad_ {
    protected float length;
    public float getLength() {
        return length;
    }
    public void setLength(float length) {
        this.length = length;
    }
    protected float width;
    public float getWidth() {
        return width;
    }
    public void setWidth(float width) {
        this.width = width;
    }
    public static void main(String[] args){
        Rectangle rect = new Rectangle();
        rect.setCx(23); // From GeoShape Class
        System.out.println("Access from Geo Shape " + rect.getCx());
        rect.setDiagonal(40); // From Quad Class
        System.out.println("Access from Quad " + rect.getDiagonal());
        rect.setWidth(78);
        System.out.println("Access from Rectangle " + rect.getWidth());
    }
    
}

