#include<iostream>
using namespace std;
class Shape {
    public:
    /*
    It is a pure virtual Function. It means that it has no body here and the body would 
    be defined in the derived class.
    */
    virtual void etavirtual() = 0;
    protected:
        // it is the member fuction of this class which can be accessed by the the child of the derived class if the derived class is a virtual class.
        void dadarSompod(){
            cout << "Dadar Sompod pacche" << endl;
        }
    
};
// This is the derived virtual class of the Shape class.
class GolKichuEkta : virtual protected Shape{
    protected:
        void baperSompod(){
            cout << "Baper Sompod" << endl;
        }
    // Defining the body of the pure virtual function
    void etavirtual(){
        cout << "Ammar Virtual " << endl;
    }
    
};
// This is the derived virtual class of the Shape class.
class DekhaJay : virtual protected Shape{
    // Defining the body of the pure virtual function
    void etavirtual(){
        cout << "hahcC Virtual " << endl;
    }
    protected:
        void dekhaDe(){
            cout << "Chahchar Sompod" << endl;
        }
};
class Circle : private GolKichuEkta, private DekhaJay{
    protected:
    // Defining the body of the pure virtual function
    void etavirtual(){
        cout << "Nijer Virtual " << endl;
    }
    public:
        void nijerSompod(){
            cout << "Eta nijer Sompod" << endl;
            baperSompod(); // accessing the method of the parent GolKichuEkta class
            dekhaDe(); // accessing the method of the parent DekhaJay class
            dadarSompod(); // accessing the method of the grandparent Shape class as the parent GolKichuEkta and DekhaJay are virtual class.
            Shape * ma = new GolKichuEkta(); // creating a pointer of the Shape class and pointing it to the GolKichuEkta class.
            ma->etavirtual(); // calling the virtual function of the GolKichuEkta class.
            ma = new DekhaJay(); // pointing the pointer to the DekhaJay class.
            ma->etavirtual(); // calling the virtual function of the DekhaJay class.
        }

};
int main(){
    Circle circle;
    circle.nijerSompod();
}