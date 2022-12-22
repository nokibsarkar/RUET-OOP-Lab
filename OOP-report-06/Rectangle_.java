class GeoShape_ {
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
class Triangle extends GeoShape {
    private float largest_angle;
    public float getLargest_angle() {
        return largest_angle;
    }
    public void setLargest_angle(float largest_angle) {
        this.largest_angle = largest_angle;
    }
}
class Quad_ extends GeoShape {
    protected float diagonal;
    public float getDiagonal() {
        return diagonal;
    }
    public void setDiagonal(float diagonal) {
        this.diagonal = diagonal;
    }
    
}
public class Rectangle_ extends Quad_ {
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
        Rectangle_ rect = new Rectangle_();
        rect.setCx(23); // From GeoShape Class
        System.out.println("Access from Geo Shape " + rect.getCx());
        rect.setDiagonal(40); // From Quad Class
        System.out.println("Access from Quad " + rect.getDiagonal());
        Triangle tri = new Triangle();
        tri.setCx(45); // From GeoShape Class
        System.out.println("Access from Geo Shape " + tri.getCx());
        tri.setLargest_angle(60); // From Triagnle Class
        System.out.println("Access from Triangle " + tri.getLargest_angle());
    }
    
}

