// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class XTotalShapes
{
    public static void main(String[] args) throws IOException
    {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // int T = Integer.parseInt(br.readLine().trim());
        // while(T-->0)
        // {
        //     String[] s = br.readLine().trim().split(" ");
        //     int n = Integer.parseInt(s[0]);
        //     int m = Integer.parseInt(s[1]);
        //     char[][] grid = new char[n][m];
        //     for(int i = 0; i < n; i++){
        //         String S = br.readLine().trim();
        //         for(int j = 0; j < m; j++){
        //             grid[i][j] = S.charAt(j);
        //         }
        //     }
        //     Solution obj = new Solution();
        //     int ans = obj.xShape(grid);
        //     System.out.println(ans);
        // }
        Solution obj = new Solution();
        // int ans = obj.xShape(new char[][]{"XOX".toCharArray(), "OXO".toCharArray(), "XXX".toCharArray()});
        // int ans = obj.xShape(new char[][]{"XXXXOO".toCharArray(), "XXXXXO".toCharArray(), "OOOOOO".toCharArray()});
        int ans = obj.xShape(new char[][]{"XXXX".toCharArray(), "XXXX".toCharArray(), "XXXX".toCharArray()});
        System.out.println(ans);
    }
    static class Solution {
        //Function to find the number of 'X' total shapes.
        public int xShape(char[][] grid)
        {
            int rows = grid.length;
            int cols = grid[0].length;
            int count = 0;
            boolean[][] dp = new boolean[rows][cols];
            for(int i = 0; i < rows; i++) {
                for(int j = 0; j < cols; j++) {
                    if(grid[i][j] == 'X' && !dp[i][j]) {
                        updateDpArr(dp, i, j, grid);
                        count += 1;
                    }
                }
            }
            return count;
        }

        public void updateDpArr(boolean[][]dp, int i, int j, char[][] grid) {
            if(grid[i][j] == 'X' && !dp[i][j]){
                dp[i][j] = true;
                if(i+1 < grid.length) {
                    updateDpArr(dp, i+1, j, grid);
                }
                if(i-1 >= 0) {
                    updateDpArr(dp, i-1, j, grid);
                }
                if(j+1 < grid[0].length) {
                    updateDpArr(dp, i, j+1, grid);
                }
                if(j-1 >= 0) {
                    updateDpArr(dp, i, j-1, grid);
                }
            }
        }
    }
}// } Driver Code Ends