#include <stdio.h>
void display();

int main()
{
    display();
    display();
}
void display()
{
    static int a = 1;
    a += 5;
    printf("%d  ",a);
}

// Every variable contains 2 property: type và Storage Class.
// type refers to the data type of a variable. 
// And Storage Class defines the scope, visibility, and lifetime of a variable.

// There are 4 types of Storage Class:
// automatic : auto int a = 1
// external : extern int a = 1
// register : register int a = 1
// static : static int a = 1





