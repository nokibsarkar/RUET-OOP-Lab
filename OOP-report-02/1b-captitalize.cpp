/* This program capitalize the first letter of each word of a given string.
Words must be separated by only one space. */
#include <iostream>
#include <string>
using namespace std;
int main(){
    string str;
    getline(cin, str);
    int len = str.length();
    for(int i = 0; i < len; i++){
        if(i == 0){
            str[i] = toupper(str[i]);
        }
        else if(str[i] == ' '){
            str[i + 1] = toupper(str[i + 1]);
        }
    }
    cout << str << endl;
    return 0;
}