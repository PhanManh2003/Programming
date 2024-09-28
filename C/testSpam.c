#include <stdio.h>
#include <string.h>


int main(){
	char token[7] = "nguyen";
	char str[15] = "abc oc cho";
	strcpy(str+4,token);
	printf("%s",str);
	return 0;
}
