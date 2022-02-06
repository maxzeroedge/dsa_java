// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class AllParenthesis{
    
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        
        int t = Integer.parseInt(sc.next());
        while(t>0)
        {
            int n = Integer.parseInt(sc.next());
            Solution T = new Solution();
            List<String> ans = T.AllParenthesis(n);
            String[] sequences = ans.toArray(new String[0]);
            Arrays.sort(sequences);
            int k = sequences.length;
            for(int i=0;i<k;i++)
            {
                System.out.println(sequences[i]);
            }
            
            t--;
            
        }
    }

    static class Solution {
    
        public List<String> AllParenthesis(int n) 
        {
            // Write your code here
            if(n == 1){
                return List.of("()");
            }
            String startString = "";
            for(int i = 0; i < n; i++) { // First and last are fixed ( and )
                startString = "(" + startString + ")";
            }
            Set<String> output = new HashSet<>();
            output.add(startString);
            int left = 1, right = startString.length() - 2;
            while(left < right) {
                //System.out.println(String.format("%d %d", left, right));
                char[] charArray = startString.toCharArray();
                char temp = charArray[left];
                charArray[left] = charArray[right];
                charArray[right] = temp;
                output.add(new String(charArray));
                if(left < right - 1) {
                    right -= 1;
                } else {
                    left += 1;
                    right = startString.length() - 2;
                }
            }
            return new ArrayList<>(output);
        }
    }
}
// } Driver Code Ends