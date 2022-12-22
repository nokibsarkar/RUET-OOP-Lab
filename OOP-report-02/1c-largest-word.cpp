/*C++ program to find the largest word in a given string and print that word */
#include <iostream>
#include <string>
using namespace std;
int main(){
    string str;
    getline(cin, str);
    int len = str.length();
    int mx = 0;
    int start = 0;
    int end = 0;
    for(int i = 0; i < len; i++){
        if(str[i] == ' '){
            // got an empty space
            if(mx < i - start){
                // found a new largest word
                mx = i - start; // length of the largest word
                end = i; // end index of the largest word
            }
            start = i + 1; // start index of the next word
        }
    }
    // check the last word
    if(mx < len - start){
        // the largest word is the last word
        mx = len - start;   // length of the largest word
        end = len;  // end index of the largest word
    }
    // print the largest word
    for(int i = end - mx; i < end; i++){
        cout << str[i];
    }
    cout << endl;
    return 0;
}