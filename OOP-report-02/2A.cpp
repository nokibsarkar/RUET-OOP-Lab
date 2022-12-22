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
#include <iostream>
#include <string>
using namespace std;
/** Part a start **/
class Date {
    private:
    int day;
    int month;
    int year;
    public:
    Date(){
        day = 0;
        month = 0;
        year = 0;
    }
    Date(int day, int month, int year){
        this->day = day;
        this->month = month;
        this->year = year;
    }
    string print(void){
        string s;
        s += to_string(day);
        s += "/";
        s += to_string(month);
        s += "/";
        s += to_string(year);
        return s;
    }
};
class Cloth {
    public:
        string shopName;
        string customerName;
        string clothType;
        string tailorName;
        float size;
        int price;
        Date dateDelivered;
        Cloth(){
            shopName = "";
            customerName = "";
            clothType = "Shirt";
            tailorName = "";
            size = 0;
            price = 0;
            dateDelivered = Date(0, 0, 0);
        }
        Cloth(string shopName, string customerName, string clothType, string tailorName, float size, int price, Date dateDelivered){
            this->shopName = shopName;
            this->customerName = customerName;
            this->clothType = clothType;
            this->tailorName = tailorName;
            this->size = size;
            this->price = price;
            this->dateDelivered = dateDelivered;
        }
        /** for part c*/
        void print(void){
            cout << "Customer Name: " << customerName << endl;
            cout << "Price: " << price << endl;
            cout << "Date Delivered: " << dateDelivered.print() << endl;
        }
};
/*** Part a end ***/
int main(){
    /*** part b started **/
    Cloth cloth1;
    cloth1.clothType = "Shirt";
    cloth1.customerName = "Rahim";
    cloth1.dateDelivered = Date(1, 11, 2020);
    cloth1.price = 1000;
    cloth1.size = 2.5;
    cloth1.shopName = "ECE Fasion Pro";
    cloth1.tailorName = "Karim";
    /*** part b ended **/
    /*** part c started **/
    cloth1.print();
    /*** part c ended **/
    /** part d started **/
    Cloth clothArr[5];
    clothArr[0] = Cloth("ECE Fasion Pro", "Rahim", "Shirt", "Karim", 2.5, 1000, Date(1, 11, 2020));
    clothArr[1] = Cloth("ECE Fasion Pro", "Karim", "Pant", "Rahim", 3.5, 2000, Date(2, 11, 2020));
    clothArr[2] = Cloth("ECE Fasion Pro", "Rahim", "Shirt", "Karim", 2.5, 1000, Date(1, 11, 2020));
    clothArr[3] = Cloth("ECE Fasion Pro", "Karim", "Pant", "Rahim", 3.5, 2000, Date(2, 11, 2020));
    clothArr[4] = Cloth("ECE Fasion Pro", "Rahim", "Shirt", "Karim", 2.5, 1000, Date(1, 11, 2020));
    /** part d ended **/
    float total_price = 0;
    for(int i = 0; i < 5; i++){
        total_price += clothArr[i].price;
    }
    cout << "Total Price: " << total_price << endl;
}