import java.time.LocalDate;
public class Cloth_Private {
    private String shopName = "ECE Fashion Pro";
    private String customerName;
    private String clothType;
    private String tailorName;
    private int size;
    private int price;
    private LocalDate dateDelivered;
    public String get_Customer_Name() {
        return this.customerName;
    }
    public String get_Cloth_Type() {
        return this.clothType;
    }
    public String get_Tailor_Name() {
        return this.tailorName;
    }
    public int get_Size() {
        return this.size;
    }
    public int get_Price() {
        return this.price;
    }
    public String get_Date_Delivered() {
        return this.dateDelivered.toString();
    }
    public void set_Customer_Name(String customerName) {
        this.customerName = customerName;
    }
    public void set_Cloth_Type(String clothType) {
        this.clothType = clothType;
    }
    public void set_Tailor_Name(String tailorName) {
        this.tailorName = tailorName;
    }
    public void set_Size(int size) {
        this.size = size;
    }
    public void set_Price(int price) {
        this.price = price;
    }
    public void set_Date_Delivered(String dateDelivered) {
        this.dateDelivered = LocalDate.parse(dateDelivered);
    }
    public void increment_delivery_day(int delta){
        this.dateDelivered = this.dateDelivered.plusDays(delta);
    }
    public Cloth_Private(String customerName, String clothType, String tailorName, int size, int price, String dateDelivered) {
        this.customerName = customerName;
        this.clothType = clothType;
        this.tailorName = tailorName;
        this.size = size;
        this.price = price;
        this.dateDelivered = LocalDate.parse(dateDelivered);
    }
    public float get_price_per_sq_ft() {
        return (float) this.price / this.size;
    }
    public String toString() {
        return (
            "Customer Name : " + this.shopName
            + "\n Price : " + this.price
            + "\n Date Delivered : " + this.dateDelivered
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
