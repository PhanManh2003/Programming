#include <stdio.h>

int main()
{
    int month, year;

    printf("Enter the month (1-12): ");
    scanf("%d", &month);

    printf("Enter the year: ");
    scanf("%d", &year);

    // Check if it's a leap year
    int isLeapYear = ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0));

    // Check if the month is valid
    if (month < 1 || month > 12)
    {
        printf("Invalid month.\n");
    }
    else
    {
        if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12)
        {
            printf("31 days.");
        }
        else if (month == 2)
        {
            if (isLeapYear)
            {
                printf("29 days.");
            }
            else
            {
                printf("28 days.");
            }
        }
        else
        {
            printf("30 days.");
        }
    }

    return 0;
}

