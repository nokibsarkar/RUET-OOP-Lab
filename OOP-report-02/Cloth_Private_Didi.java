import java.time.LocalDate;
public class Cloth_Private_Didi {
    private String shop = "ECE Fashion Pro";
    private String customer;
    private String type;
    private String tailor;
    private int size;
    private int price;
    private LocalDate delivered;
    public String get_Customer_Name() {
        return this.customer;
    }
    public String get_Cloth_Type() {
        return this.type;
    }
    public String get_Tailor_Name() {
        return this.tailor;
    }
    public int get_Size() {
        return this.size;
    }
    public int get_Price() {
        return this.price;
    }
    public String get_Date_Delivered() {
        return this.delivered.toString();
    }
    public void set_Customer_Name(String customerName) {
        this.customer = customerName;
    }
    public void set_Cloth_Type(String type) {
        this.type = type;
    }
    public void set_Tailor_Name(String tailorName) {
        this.tailor = tailorName;
    }
    public void set_Size(int size) {
        this.size = size;
    }
    public void set_Price(int price) {
        this.price = price;
    }
    public void set_Date_Delivered(String dateDelivered) {
        this.delivered = LocalDate.parse(dateDelivered);
    }
    public void increment_delivery_day(int delta){
        this.delivered = this.delivered.plusDays(delta);
    }
    public Cloth_Private_Didi(String customerName, String type, String tailorName, int size, int price, String dateDelivered) {
        this.customer = customerName;
        this.type = type;
        this.tailor = tailorName;
        this.size = size;
        this.price = price;
        this.delivered = LocalDate.parse(dateDelivered);
    }
    public float get_price_per_sq_ft() {
        return (float) this.price / this.size;
    }
    public String toString() {
        return (
            "Customer Name : " + this.shop
            + "\n Price : " + this.price
            + "\n Date Delivered : " + this.delivered
        );
    }
    public static void main(String args[]){
        Cloth_Private_3 cloth1 = new Cloth_Private_3("ECE Fasion Pro", "John", "Shirt", "Tailor1", 10, 100, "2020-08-01");
        System.out.println(cloth1);
        Cloth_Private_3 cloth2 = new Cloth_Private_3("ECE Fasion Pro", "John", "Shirt", "Tailor1", 10, 100, "2020-08-01");
        System.out.println(cloth2);
        Cloth_Private_3 cloth3 = new Cloth_Private_3("ECE Fasion Pro", "John", "Shirt", "Tailor1", 10, 100, "2020-08-01");
        System.out.println(cloth3);
        Cloth_Private_3 cloth4 = new Cloth_Private_3("ECE Fasion Pro", "John", "Shirt", "Tailor1", 10, 100, "2020-08-01");
        System.out.println(cloth4);
        Cloth_Private_3 cloth5 = new Cloth_Private_3("ECE Fasion Pro", "John", "Shirt", "Tailor1", 10, 100, "2020-08-01");
        System.out.println(cloth5);
    }
}
