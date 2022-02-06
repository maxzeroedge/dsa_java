import java.io.*;
import java.util.*;

public class PrerequisiteTasks {
    // { Driver Code Starts
    //Initial Template for Java
    /*
68
16
1 25
10 64
16 10
19 61
21 31
28 53
31 56
34 7
36 20
40 27
45 48
46 52
47 30
47 39
49 10
51 2 

2
2
1 0
0 1

25
10
0 23
7 21
8 0
8 5
8 8
8 12
9 23
13 3
19 24
23 15*/

    public static void main(String args[]) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0)
        {
            int N = sc.nextInt();
            int P = sc.nextInt();
            int prerequisites[][] = new int[P][2];
            for(int i=0;i<P;i++)
            {
                for(int j=0;j<2;j++)
                {
                    prerequisites[i][j] = sc.nextInt();
                }
            }
            Solution ob = new Solution();
            if(ob.isPossible(N,prerequisites))
            {
                System.out.println("Yes");
            }
            else{
                System.out.println("No");
            }
            t--;
        }
    }
    //User function Template for Java

    static class Solution {

        public boolean getCompletionStatus(int i, Map<Integer, List<Integer>> prerequisiteMap, Map<Integer, Boolean> completionMap) {
            for(Integer prereq: prerequisiteMap.get(i)) {
                if(!completionMap.getOrDefault(prereq, false)) {
                    return false;
                }
            }
            return true;
        }

        public void updateCompletionStatus(int i, Map<Integer, List<Integer>> prerequisiteMap, Map<Integer, Boolean> completionMap) {
            if(!completionMap.containsKey(i)) {
                completionMap.put(i, false);
                if(prerequisiteMap.containsKey(i)) {
                    for(Integer prereq: prerequisiteMap.get(i)) {
                        updateCompletionStatus(prereq, prerequisiteMap, completionMap);
                    }
                    completionMap.put(i, getCompletionStatus(i, prerequisiteMap, completionMap));
                } else {
                    completionMap.put(i, true);
                }
            }
        }

        public boolean isPossible(int N, int[][] prerequisites)
        {
            Map<Integer, List<Integer>> prerequisiteMap = new HashMap<>();
            Map<Integer, Boolean> completionMap = new HashMap<>();
            // Your Code goes here
            for(int[] preqPair: prerequisites) {
                if(preqPair[0] == preqPair[1]) {
                    return false;
                }
                if(!prerequisiteMap.containsKey(preqPair[0])) {
                    prerequisiteMap.put(preqPair[0], new ArrayList<>());
                }
                prerequisiteMap.get(preqPair[0]).add(preqPair[1]);
            }
            for(int i = 0; i < N; i++) {
                updateCompletionStatus(i, prerequisiteMap, completionMap);
                if(!completionMap.getOrDefault(i, false)) {
                    return false;
                }
            }
            return true;
        }
        
    }
}
