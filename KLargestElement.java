
import java.util.*;
import java.io.*;

public class KLargestElement {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int k = Integer.parseInt(inputLine[1]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int[] ans = new Solution().kLargest(arr, n, k);
            for (int x : ans) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }
    
    
    static class Solution {
        int[] kLargest(int[] arr, int n, int k) {
            Arrays.sort(arr);
            int[] kLargestArray = new int[k];
            for(int i = n - 1; i >= n-k; i--) {
                kLargestArray[n-i-1] = arr[i];
            }
            return kLargestArray;
        }
    }
}

