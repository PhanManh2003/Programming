#include<math.h>
#include<conio.h>
#include<stdio.h>
#include<string.h>
int main()
{
    float a,b,c,d;
    printf("Nhap vao 3 so a, b, c: ");
    scanf("%f%f%f",&a,&b,&c);
    if(a==0)
    {
        if(b==0)
            {
                if(c==0)
                    printf("Phuong trinh co vo so nghiem!");
                else
                    printf("Phuong trinh vo nghiem!");
            }
        else
            printf("Phuong trinh co nghiem duy nhat la: %.2f",-c/b);
    }
    else
    {
        d=b*b-4*a*c;
        if (d<0)
            printf("Phuong trinh vo nghiem!!!");
        else if (d==0)
            printf("Phuong trinh co nghiem kep la: %.2f",-b/(2*a));
        else
            printf("Phuong trinh co 2 nghiem phan biet la: %.2f,%.2f",(-b+sqrt(d))/(2*a),(-b-sqrt(d))/(2*a));    
    }    
    return 0;
}
