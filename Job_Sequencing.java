import java.util.Scanner;
import java.util.Arrays;
import java.util.*;
class Jobsequencing {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter total number of jobs:: ");
		int jobs = sc.nextInt();
         
        //Array of objects of class Jobs
		Jobs[] j = new Jobs[jobs];
        int maxdeadline = Integer.MIN_VALUE;;
		for(int i=0; i<jobs; i++) {
			
			int jobnumber= sc.nextInt();
			int profit = sc.nextInt();
			int deadline = sc.nextInt();

			if(deadline > maxdeadline) {
				maxdeadline = deadline;
            }

			j[i] = new Jobs(jobnumber,profit,deadline);
		}
        

        Arrays.sort(j, new Sortbyprofit());
     
        boolean[] b = new boolean[maxdeadline];
        int[] seq = new int[maxdeadline];

        for(int i=0; i<jobs; i++) {
        	for(int k=j[i].deadline-1; k>=0; k--) {
        		if(b[k] == false) {
        			b[k] = true;
        			seq[k] = j[i].job_number;
        			break;
        		}
        	}
        }

        for(int i=0; i<maxdeadline; i++) {
        	System.out.println(seq[i]);
        }
      

	}
}
class Sortbyprofit implements Comparator<Jobs> {
	public int compare(Jobs j1, Jobs j2) {
		return -(j1.profit - j2.profit);
	}
}
class Jobs {
	int job_number;
	int profit;
	int deadline;

	Jobs(int x, int y, int z) {
		this.job_number = x;
		this.profit = y;
		this.deadline = z;
	}


}