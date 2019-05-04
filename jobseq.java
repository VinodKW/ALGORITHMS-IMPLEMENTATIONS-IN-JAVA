import java.util.Scanner;
import java.util.Arrays;

class Jobsequencing {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter total number of jobs:: ");
		int jobs = sc.nextInt();
         
        //Array of objects of class Jobs
		Jobs[] j = new Jobs[jobs];

		for(int i=0; i<jobs; i++) {
			j[i] = new Jobs();
			j[i].job_number = sc.nextInt();
			j[i].profit = sc.nextInt();
			j[i].deadline = sc.nextInt();
		}
        

        Arrays.sort(j, new Sortbyprofit());

       for(int i=0; i<jobs; i++) {
           System.out.printf("%d\t%d\%d\t",j[i].job_number,j[i].profit,j[i].deadline);
       }

	}
}
class Sortbyprofit implements comparator<Jobs>
{
	public int compare(Jobs j1, Jobs j2) {
		return j2.profit - j1.profit;
	}
}
class Jobs {
	int job_number;
	int profit;
	int deadline;
}