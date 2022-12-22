#include <stdio.h>
int main(){
    int row, column;
    printf("Enter row and column  ");
    scanf("%d %d", &row, &column);
    int n = row > column ? row : column;
    int a_n = 1 + n * (n + 1);
    int result = a_n;
    if( row < n)
        if(n % 2)
            result -= n - row;
        else
            result += n - row;
    else if(column < n)
        if(n % 2)
            result += n - column;
        else
            result -= n - column;
    printf("The spiral number at (%d, %d) = %d\n", row, column, result); 
}