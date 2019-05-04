#include <stdio.h>
int main() {

	int ans[5];
	int boolean[5];
	int index = 0;

	int process[5] = {1,2,3,4,5};
	int total[3] = {10,5,7};
    int availaible[3] = {10,5,7};
	int allocation[5][3] = {{0,1,0},{2,0,0},{3,0,2},{2,1,1},{0,0,2}};
	int maxneed[5][3] = {{7,5,3},{3,2,2},{9,0,2},{4,2,2},{5,3,3}};

	int remneed[5][3];

	for(int i = 0; i<5; i++) {
		for(int j = 0; j<3; j++) {
			remneed[i][j] = maxneed[i][j] - allocation[i][j];
		}
	}
    

    

    for(int i = 0; i<5; i++) {
    		availaible[0] -= allocation[i][0];
    		availaible[1] -= allocation[i][1];
    		availaible[2] -= allocation[i][2];
    }
    
    for(int i = 0; i<5; i++) {
    	boolean[i] = 0;
    }
    
    for(int i = 0; i<5; i++) {
    	for(int j = 0; j<5; j++) {
            
           if(boolean[j] == 0) {
                int flag = 0;
           	    for(int k = 0; k<3; k++) {
           	    	if(remneed[j][k] > availaible[k]) {
           	    		flag = 1;
           	    		break;
           	    	}
           	    }

           	    if(flag == 0) {
           	        ans[index++] = j;
           	        for(int k =0;k<3; k++) {
           	        	availaible[k] += allocation[j][k];
           	        	boolean[j] = 1;
           	        }
           	    }
           }
    	}
    }

    for(int i = 0; i<5; i++) {
    	printf("%d\t",ans[i]);
    }

    return 0;
}