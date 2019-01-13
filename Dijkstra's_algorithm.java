import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    
    static int minvalue(int[] key,int n, Boolean[] set)
    {
      int min = Integer.MAX_VALUE;
      int index = -1;
      for(int i = 0; i<n ; i++)
      {
        if(key[i]<=min && !set[i])
        {
          min = key[i];
          index = i;
        }
      }
      return index;
    }
    static int[] shortestReach(int n, int[][] graph, int s) {

      LinkedList<Integer> l = new LinkedList();

      int[] parent = new int[n];
      int[] key = new int[n];
      Boolean[] set = new Boolean[n];

      for(int i = 0 ; i<n ;i++)
      {
        key[i] = Integer.MAX_VALUE;
        set[i] = false;
      }

      key[s-1] = 0;
      parent[s-1] = -1;

      for(int count = 0 ; count<n-1 ; count++)
      {
        int u = minvalue(key,n,set);
       
        

         set[u] = true;

        for(int v = 0 ; v<n ;v++)
        {
          if(!set[v] && graph[u][v]!= 0 && key[u]!=Integer.MAX_VALUE && key[u] + graph[u][v] < key[v])
          {
                 key[v] = key[u] + graph[u][v];
                 parent[v] = u;
          }
        }
         
      }
        int count = 0;
        for(int i = 0; i<n ; i++)
        {
           if(key[i] == Integer.MAX_VALUE)
           {
             l.add(-1);
             count++;
           }
           else
           if(key[i]!=0)
           {
             l.add(key[i]);
            count++;
           }

            
          
        }
        int[] result = new int[count];
        for(int i = 0 ;i<count ;i++)
        {
          result[i] =(int)l.get(i);
        }

        return result;

      

    


    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String[] nm = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nm[0]);

            int m = Integer.parseInt(nm[1]);

            int[][] graph = new int[n][n];
            int row = 0; 
            int column = 0; 
            for (int i = 0; i < m; i++) {
                String[] edgesRowItems = scanner.nextLine().split(" ");
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
               
                for (int j = 0; j < 3; j++) {
                    int Item = Integer.parseInt(edgesRowItems[j]);
                    
                    if(j == 0)
                    {
                      row = Item;
                    }
                    else
                    if(j == 1)
                    {
                      column = Item;
                    }
                   else
               {
                    if(graph[column-1][row-1] != 0 && graph[column-1][row-1] >Item || graph[row-1][column-1] != 0 && graph[row-1][column-1] > Item)
                 {
                   graph[column-1][row-1] = Item;
                   graph[row-1][column-1] = Item;
                                                         
                 }
                 else
                 if(graph[column-1][row-1] == 0 || graph[row-1][column-1] == 0)
                 {
                   graph[column-1][row-1] = Item;
                   graph[row-1][column-1] = Item;

                 }
               }
              }
            }

            int s = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] result = shortestReach(n, graph, s);

            for (int i = 0; i < result.length; i++) {
                bufferedWriter.write(String.valueOf(result[i]));

                if (i != result.length - 1) {
                    bufferedWriter.write(" ");
                }
            }

            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
