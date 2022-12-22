#include <bits/stdc++.h>
using namespace std;
class GeoShape {
    protected:
        float cx, cy;
        int n;
        void setCx(float x){
            cx = x;
        }
};
class Quad : protected GeoShape {
    protected:
    string name = "Quad";
    float diagonal;
    void setDiagonal(float d){
        diagonal = d;
    }
    float getDiagonal(){
        return diagonal;
    }
    
};
class Rectangle : virtual protected Quad {
    protected:
    float length;
    string name = "Rectangle";
    float getLength() {
        return length;
    }
    void setLength(float length) {
        this->length = length;
    }
    
};
class Square : virtual protected Quad {
    protected:
    float side;
    string name = "Square";
    float getSide() {
        return side;
    }
    void setSide(float side) {
        this->side = side;
    }
};
class SmallSq :  private Square, private Rectangle {
    public:
    void draw(){
        cout << "Calling from Small Square" << endl;
        this->setLength(30); // From Rectangle
        cout << "Set Length for Rectangle " << this->getLength() << endl;
        this->setSide(4); // From Square
        cout << "Set Side for Square " << this->getSide() << endl;
        this->setDiagonal(10); // From Quad
        cout << "Access Quad " << this->getDiagonal() << endl;
        this->setCx(12); // From GeoShape
        cout << "Access GeoShape " << this->cx << endl;
    }
};
int main(){
    SmallSq ssq = SmallSq();
    ssq.draw();
}
