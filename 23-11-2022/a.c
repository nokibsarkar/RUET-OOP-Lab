#include <stdio.h>
 
int main() {
 
    /**
     * Escreva a sua solução aqui
     * Code your solution here
     * Escriba su solución aquí
     */
     int unsigned long a, b;
     while(scanf("%lu %lu", &a, &b) != EOF){
         printf("%lu\n", a ^ b);
         continue;
     }
    return 0;
}