#include <stdio.h>
int main()
{
    int i, j;
    char a[10], temp, c;
    printf("enter data\n");
    for (i = 0; i < 10; i++)
        scanf("%c%*c", &a[i]);
    for (j = 0; j < 9; j++)
        if (a[j] < a[j + 1])
            temp = a[j];
        else
            temp = a[j + 1];
    printf("%c", temp);
    return 0;
}