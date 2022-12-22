#include <bits/stdc++.h>
int main(){
    int n;
    std::cin >> n;
    int arr[n];
    for(int i = 0; i < n; i++){
        std::cin >> arr[i];
    }
    std::sort(arr, arr + n);
    std::cout << arr[1];
    return 0;
}