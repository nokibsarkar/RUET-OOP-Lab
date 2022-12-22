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
int DAY_OF_MONTHS[13] = {29, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
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
    bool is_leap_year(){
        if(year % 400 == 0){
            return true;
        }
        if(year % 100 == 0){
            return false;
        }
        if(year % 4 == 0){
            return true;
        }
        return false;
    }
    int increment_day(int delta){
        day += delta;
        int month_capacity = DAY_OF_MONTHS[month];
        if(is_leap_year()){
            month_capacity = 29;
        }
        if(day > month_capacity){
            // overflown
            day -= month_capacity;
            month++;
            if(month > 12){
                month -= 12;
                year++;
            }
        }
        return 0;
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
    private:
        string shopName = "ECE Fashion Pro";
        string customerName;
        string clothType;
        string tailorName;
        float size;
        int price;
        Date dateDelivered;
    public:
        Cloth(){
            shopName = "ECE Fasion Pro";
            customerName = "";
            clothType = "Shirt";
            tailorName = "";
            size = 0;
            price = 0;
            dateDelivered = Date(0, 0, 0);
        }
        Cloth(string customerName, string clothType, string tailorName, float size, int price, Date dateDelivered){
            this->shopName = "ECE Fasion Pro";
            this->customerName = customerName;
            this->clothType = clothType;
            this->tailorName = tailorName;
            this->size = size;
            this->price = price;
            this->dateDelivered = dateDelivered;
        }
        string get_Customer_Name(void){
            return customerName;
        }
        string get_Cloth_Type(void){
            return clothType;
        }
        string get_Tailor_Name(void){
            return tailorName;
        }
        float get_Size(void){
            return size;
        }
        float get_Price(void){
            return price;
        }
        Date get_Date_Delivered(void){
            return dateDelivered;
        }
        void set_Customer_Name(string customerName){
            this->customerName = customerName;
        }
        void set_Cloth_Type(string clothType){
            this->clothType = clothType;
        }
        void set_Tailor_Name(string tailorName){
            this->tailorName = tailorName;
        }
        void set_Size(float size){
            this->size = size;
        }
        void set_Price(int price){
            this->price = price;
        }
        void set_Date_Delivered(Date dateDelivered){
            this->dateDelivered = dateDelivered;
        }
        float get_price_per_sq_feet(void){
            return price / size;
        }
        void increment_delivery_date(int days){
            dateDelivered.increment_day(days);
        }
        /** for part c*/
        void print(void){
            cout << "Customer Name: " << customerName << endl;
            cout << "Price: " << price << endl;
            cout << "Date Delivered: " << dateDelivered.print() << endl;
        }
};
int main(){
    Cloth cloth1;
    cloth1.set_Customer_Name("Rahim");
    cloth1.set_Price(1000);
    cloth1.set_Date_Delivered(Date(28, 2, 2020));
    cloth1.print();
    // Increment the date by 2 days
    cloth1.increment_delivery_date(2);
    cloth1.print();
}