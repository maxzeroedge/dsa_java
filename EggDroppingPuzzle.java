
import java.util.*;
import java.lang.*;
import java.io.*;

public class EggDroppingPuzzle {
    
    public static void main (String[] args) throws IOException  {
        
        //reading input using BufferedReader class
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        //reading total testcases
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0){
            
            //reading number of eggs and floors
            String inputLine[] = br.readLine().trim().split(" ");
            
            int n = Integer.parseInt(inputLine[0]);
            int k = Integer.parseInt(inputLine[1]);
            
            //calling eggDrop() method of class
            //EggDrop
            System.out.println(new Solution().eggDrop(n, k));
        }
    }

    static class Solution 
    {
        //Function to find minimum number of attempts needed in 
        //order to find the critical floor.
        static int eggDrop(int n, int k) 
        {
            // Your code here
            int[][] eggFloor = new int[n+1][k+1];
            for(int i = 1; i <= n; i++) {
                eggFloor[i][1] = 1;
                eggFloor[i][0] = 0;
            }
            for(int j = 0; j <= k; j++) {
                eggFloor[1][j] = j;
            }
            for(int i = 2; i <= n; i++) {
                for(int j = 2; j <= k; j++) {
                    eggFloor[i][j] = Integer.MAX_VALUE;
                    for(int x = 1; x <= j; x++) {
                        int res = 1 + Math.max(eggFloor[i-1][x-1], eggFloor[i][j-x]);
                        if(res < eggFloor[i][j]) {
                            eggFloor[i][j] = res;
                        }
                    }
                }
            }
            return eggFloor[n][k];
        }
    }
}