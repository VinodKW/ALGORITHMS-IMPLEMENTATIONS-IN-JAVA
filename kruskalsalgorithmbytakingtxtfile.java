import java.io.*;


import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Filewriter{
	
	static class set{
		int parent,rank;
	}
	
	//find set which represents vertex i
	static int find(set subsets[],int i ){
		if(subsets[i].parent==i)
			return i;
		return find(subsets,subsets[i].parent);
	}
	
	//function for adding  edges whose vertex belongs 
	//to the different tree ie. UNION
	static void UNION(set subsets[],int x,int y){
		int xroot=find(subsets,x);
		int yroot=find(subsets,y);

		if(subsets[xroot].rank>subsets[yroot].rank)
			subsets[yroot].parent=xroot;
		else if(subsets[xroot].rank<subsets[yroot].rank)
			subsets[xroot].parent=yroot;
		else{
			subsets[yroot].parent=xroot;
			subsets[xroot].rank++;
		}
	}
	
	static int mst(int n, Integer[][] edges) {
		set subsets[]=new set[n];

		//Create forest of vrtices that is separate tree for each vertex
		for(int i=0;i<n;i++)   
		{  
			subsets[i]=new set();
			subsets[i].parent=i;  // Each vertex is its own parent
			subsets[i].rank=0;   //Having no child
		}

		int e=0,i=0,count=0;
		//Create graph having exactly vertex-1 ie. n-1 edges
		while(e<n-1){
			//find set from which current vertex belongs
			int x=find(subsets,edges[i][0]-1);  
			//find set from which current vertex belongs
			int y=find(subsets,edges[i][1]-1); 

			if(x!=y){
				count+=edges[i][2];  
				e++;
				// union the two vertex in the same tree 
				//if they belong to the different set
				UNION(subsets,x,y); 
			}
			i++;
		}
		return count;
	}

	public static void main(String[] args) throws IOException
	{
        FileReader fr = new FileReader("G:\\edges.txt");
        BufferedReader fw = new BufferedReader(fr);
        String s = fw.readLine();
        String[] a = s.split(" ");
		
		int n = Integer.parseInt(a[0]);   //number of nodes
		int m = Integer.parseInt(a[1]);  //number of edges
		Integer [][]edges = new Integer[m][3];
		for(int edges_i = 0; ((edges_i < m) && (s!=null)); edges_i++ ){ 
                 s = fw.readLine();
                 a = s.split(" ");
			for(int edges_j = 0; edges_j < 3; edges_j++){
                
				edges[edges_i][edges_j] =Integer.parseInt(a[edges_j]) ;

			}
		}
		
		//Sort edges two dimensional array according to 
		//its third column i.e. weight
		Arrays.sort(edges,new Comparator<Integer[]>(){
			@Override
			public int compare(Integer[] i1,Integer[] i2){
				//Comparing third column having index 2
				return i1[2].compareTo(i2[2]);   
			}
		});
		
		int result=mst(n,edges);
		System.out.println(result);
		fw.close();
	}
}
 
