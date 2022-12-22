/**
 * Your shop makes cloths of different types. Each cloth has some properties. These are-
i. Shop name
ii. Name of the customer.
iii. Type of cloth (Pant, Pant, Suite).
iv. Name of the tailor.
v. Size of the cloth (square feet)
vi. Price
vii. Date Delivered (E.g. “1/12/2022” string)
*/
public class Cloth_Public_Didi {
    public String shop;
    public String customer;
    public String type;
    public String tailor;
    public int size;
    public int price;
    public String delivered;
    public Cloth_Public_Didi(String customer, String type, String tailor, int size, int price, String delivered) {
        this.shop = "ECE Fasion Pro";
        this.customer = customer;
        this.type = type;
        this.tailor = tailor;
        this.size = size;
        this.price = price;
        this.delivered = delivered;
    }
    public String toString() {
        return (
            "Customer Name : " + this.customer
            + "\n Price : " + this.price
            + "\n Date Delivered : " + this.delivered
        );
    }
    public static void main(String args[]){
        Cloth_Public cloth1 = new Cloth_Public("Hamilton", "Pant", "Tailor", 10, 100, "1/12/2022");
        System.out.println(cloth1);
        Cloth_Public[] clothArr = new Cloth_Public[5];
        clothArr[0] = new Cloth_Public("Hamilton", "Pant", "Tailor", 10, 100, "1/12/2022");
        clothArr[1] = new Cloth_Public("Hamilton", "Pant", "Tailor", 10, 100, "1/12/2022");
        clothArr[2] = new Cloth_Public("Hamilton", "Pant", "Tailor", 10, 100, "1/12/2022");
        clothArr[3] = new Cloth_Public("Hamilton", "Pant", "Tailor", 10, 100, "1/12/2022");
        clothArr[4] = new Cloth_Public("Hamilton", "Pant", "Tailor", 10, 100, "1/12/2022");
        int total_price = 0;
        for (int i = 0; i < clothArr.length; i++) {
            total_price += clothArr[i].price;
        }
        System.out.println("Total Price : " + total_price);
    }
}
