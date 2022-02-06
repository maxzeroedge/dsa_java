import java.io.*;

public class KadaneAlgorithm {
        
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
        while(t-->0){
            //size of array
            int n = Integer.parseInt(br.readLine().trim());
            int arr[] = new int[n];
            String inputLine[] = br.readLine().trim().split(" ");
            
            //adding elements
            for(int i=0; i<n; i++){
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            
            Solution obj = new Solution();
            
            //calling maxSubarraySum() function
            System.out.println(obj.maxSubarraySum(arr, n));
        }
    }
    
    
    static class Solution{
    
        // arr: input array
        // n: size of array
        //Function to find the sum of contiguous subarray with maximum sum.
        long maxSubarraySum(int arr[], int n){
            
            // Your code here
            int curr_start = 0, curr_end = 0; //start = 0, end = 0, 
            long maxSum = Long.MIN_VALUE, curr_sum = 0;
            for(int i = 0; i < arr.length; i++) {
                if(curr_sum + arr[i] > maxSum) {
                    curr_sum += arr[i];
                    maxSum = curr_sum;
                    // end = i;
                } else if(arr[i] < 0) {
                    curr_sum = arr[i];
                    if(maxSum < curr_sum) {
                        maxSum = curr_sum;
                    }
                    curr_start = i;
                } else {
                    if(arr[curr_start] < 0) {
                        curr_start = i;
                    }
                    curr_sum += arr[i];
                }
                curr_end = i;
            }
            return maxSum;
        }
        
    }
    
}
