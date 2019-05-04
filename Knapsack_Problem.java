import java.util.*;

class Knapsack {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter total number of Items:: ");

		int number = sc.nextInt();
        System.out.println("Enter capacity of sack");
        int capacity = sc.nextInt();

		Details[] d = new Details[number];

		for(int i=0; i<number; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int z = x/y;

			d[i] = new Details(x,y,z);
		}
        //Arrays.sort internally call quicksort to sort the given array of details
		Arrays.sort(d,new Sortbyratio());

        double totalprofit = 0;
	    for(int i=0; i<number; i++) {
	    	
	    	if(capacity - d[i].weight >= 0) {
	    		capacity -= d[i].weight;
	    		totalprofit += d[i].profit;
	    		System.out.println("hey slick");
	    		System.out.println(totalprofit);

	    	}
	    	else {
	    		double ratio = (double)capacity/(double)d[i].weight;
	    		totalprofit += (d[i].profit)*(ratio);
	    		System.out.println("I'm reachable");
	    		System.out.println(totalprofit);
	    		break;
	    	}
	    }




	}
}

class Sortbyratio implements Comparator<Details>
{
	public int compare(Details a, Details b){
		return b.ratio - a.ratio;
	}
}

class Details {
	int profit;
	int weight; 
    int ratio;
	Details(int x, int y, int z) {
		this.profit = x;
		this.weight = y;
		this.ratio = z;
	}
}