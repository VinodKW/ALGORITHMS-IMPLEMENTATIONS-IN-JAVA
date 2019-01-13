import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {



    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] roadNodesEdges = scanner.nextLine().split(" ");
        int roadNodes = Integer.parseInt(roadNodesEdges[0].trim());
        int roadEdges = Integer.parseInt(roadNodesEdges[1].trim());

         
        int[][] graph = new int[roadNodes][roadNodes];
        for(int i = 0; i<roadNodes ;i++)
        {
           for(int j = 0 ; j<roadNodes ;j++)
           {
              if(i!=j)
              {
                graph[i][j] = Integer.MAX_VALUE;
              }

           }
        }
        
        for (int i = 0; i < roadEdges; i++) {
            String[] roadFromToWeight = scanner.nextLine().split(" ");
            
            graph[Integer.parseInt(roadFromToWeight[0].trim())-1][Integer.parseInt(roadFromToWeight[1].trim())-1] = Integer.parseInt(roadFromToWeight[2].trim());
        }

        

       /* Floyd Warshall Algorthm's main logic */
       /*===============================================================================================================*/
       /*+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
       
       for(int k = 0; k<roadNodes ; k++)
        {
          for(int i = 0; i<roadNodes ; i++)
          {
            for(int j = 0 ; j<roadNodes ; j++)
            {
               if(graph[i][k] == Integer.MAX_VALUE || graph[k][j] == Integer.MAX_VALUE)
               {
                 continue;
               }
               else
               if(graph[i][j] > graph[i][k] + graph[k][j])
               {
                 graph[i][j]  = graph[i][k] + graph[k][j];
               }
            }
          }
        }
       /*+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
      /*==============================================================================================================*/
        

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String[] xy = scanner.nextLine().split(" ");

            int x = Integer.parseInt(xy[0]);

            int y = Integer.parseInt(xy[1]);

             if(graph[x-1][y-1] == Integer.MAX_VALUE)
             {
               System.out.println(-1);
             }
             else
              System.out.println(graph[x-1][y-1]);
           
        }
        

        scanner.close();
    }
}
