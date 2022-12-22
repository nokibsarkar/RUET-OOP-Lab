/**
 * Your shop makes cloths of different types. Each cloth has some properties. These are-
i. Shop name
ii. Name of the customer.
iii. Type of cloth (Shirt, Pant, Suite).
iv. Name of the tailor.
v. Size of the cloth (square feet)
vi. Price
vii. Date Delivered (E.g. “1/11/2020” string)
*/
public class Cloth_Public {
    public String shopName;
    public String customerName;
    public String clothType;
    public String tailorName;
    public int size;
    public int price;
    public String dateDelivered;
    public Cloth_Public(String customerName, String clothType, String tailorName, int size, int price, String dateDelivered) {
        this.shopName = "ECE Fasion Pro";
        this.customerName = customerName;
        this.clothType = clothType;
        this.tailorName = tailorName;
        this.size = size;
        this.price = price;
        this.dateDelivered = dateDelivered;
    }
    public String toString() {
        return (
            "Customer Name : " + this.customerName
            + "\n Price : " + this.price
            + "\n Date Delivered : " + this.dateDelivered
        );
    }
    public static void main(String args[]){
        Cloth_Public_Didi cloth1 = new Cloth_Public_Didi("John", "Shirt", "Tailor1", 10, 100, "1/11/2020");
        System.out.println(cloth1);
        Cloth_Public_Didi[] clothArr = new Cloth_Public_Didi[5];
        clothArr[0] = new Cloth_Public_Didi("John", "Shirt", "Tailor1", 10, 100, "1/11/2020");
        clothArr[1] = new Cloth_Public_Didi("John", "Shirt", "Tailor1", 10, 100, "1/11/2020");
        clothArr[2] = new Cloth_Public_Didi("John", "Shirt", "Tailor1", 10, 100, "1/11/2020");
        clothArr[3] = new Cloth_Public_Didi("John", "Shirt", "Tailor1", 10, 100, "1/11/2020");
        clothArr[4] = new Cloth_Public_Didi("John", "Shirt", "Tailor1", 10, 100, "1/11/2020");
        int total_price = 0;
        for (int i = 0; i < clothArr.length; i++) {
            total_price += clothArr[i].price;
        }
        System.out.println("Total Price : " + total_price);
    }
}
