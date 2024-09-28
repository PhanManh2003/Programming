#include <stdio.h>
// tram trau tram co
int main()
{
    int x , y, z;
    for(x = 1; x<20; x++){
        for(y = 1; y<33; y++){
            z = 100 - (x+y);
            if(((x + y + z) == 100) && (x*15 + y*9 + z) == 300){
                printf("So trau dung: %d",x);
                printf("\nSo trau nam: %d",y);
                printf("\nSo trau gia: %d\n\n",z);
            }
        }
    }
}
