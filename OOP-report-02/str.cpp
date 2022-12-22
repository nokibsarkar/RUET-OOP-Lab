#include <iostream>
#include <string>
#include <algorithm>
using namespace std;
int main(){
    string str;
    cin >> str;
    str.shrink_to_fit();
    sort(str.begin(), str.end());
    cout << str << endl;
    return 0;
}