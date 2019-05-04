#include <stdio.h>
#include <stdlih.h>

int sum(int array[], int size, int i) {
	
	if(array[i] == 0) {
	    return;
	}
	else {
	    return array[i] + sum(array, size, i+1);
	}
}
int main() {

    int array[30], size, sum;
    scanf("%d",&b);
    for(int i = 0; i<b; i++) {
        scanf("%d",&a[i]);
    }
	
	x = 0;
	c = sum(array, size, 0);
	printf("Sum:: %d ",c);
	return 0;
}