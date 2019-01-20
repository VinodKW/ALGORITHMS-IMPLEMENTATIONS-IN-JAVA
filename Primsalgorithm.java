import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {
/*********************************************************************************************************************/
  //* Prims algorithm main logic *//
    static int index_value(int[] key,int n,Boolean[] mstset)
    {
        int index = -1;
        int min = Integer.MAX_VALUE;

        for(int i = 0 ; i<n ; i++)
        {
          if(mstset[i] == false && key[i]<min)
          {
            min = key[i];
            index = i;
          }
        }

         return index;
    }
    // Complete the prims function below.
    static int prims(int n, int[][] graph, int start) {
      

      int[] parent = new int[n];
      int[] key = new int[n];
      Boolean[] mstset = new Boolean[n];

      for(int i = 0 ; i<n ; i++)
      {
        mstset[i] = false;
        key[i] = Integer.MAX_VALUE;
      }

      parent[0] = -1;
      key[0] = 0;

      for(int count = 0 ; count<n-1 ; count++)
      {
        int u = index_value(key,n,mstset);
        mstset[u] = true;
        for(int v = 0 ; v<n; v++)
        {
          if(graph[u][v] != 0 && mstset[v] == false && key[u]!=Integer.MAX_VALUE && graph[u][v]<key[v])
          {
            key[v] = graph[u][v];
            parent[v] = u;
          }
        }
      }
       int sum = 0;
      for(int i = 0; i<n ; i++)
      {
        
           sum+= key[i];
         
          
      }

      return sum;






    }
/*************************************************************************************************************************************/
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        int[][] graph = new int[n][n];

        for (int i = 0; i < m; i++) {
            String[] edgesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int row = 0;
            int column = 0;
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
                    if(graph[column-1][row-1] != 0 && graph[column-1][row-1] > Item || graph[row-1][column-1] != 0 && graph[row-1][column-1] > Item)
                 {
                   graph[column-1][row-1] = Item;
                   graph[row-1][column-1] = Item;
                                                         
                 }
                 else
                 if(graph[column-1][row-1] == 0)
                 {
                   graph[column-1][row-1] = Item;
                   graph[row-1][column-1] = Item;

                 }
               }

            }
        }

        int start = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int result = prims(n, graph, start);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

