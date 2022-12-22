#include<iostream>
using namespace std;
class P {
    public:
    int k;
};
int main(){
    P p1;
    p1.k = 5;
    P p2 = p1;
    p2.k = 6;
    p1.k = 7;
    cout << p1.k << " " << p2.k << endl;

}