import java.util.*;
import java.lang.*;
import java.io.*;
    
public class AnagramTest {
    public static void main (String[] args)throws IOException {
    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t-->0)
        {
            String str = br.readLine();
            String s1 = str.split(" ")[0];
            String s2 = str.split(" ")[1];
            
            Solution obj = new Solution();
            
            if(obj.isAnagram(s1,s2))
            {
                System.out.println("YES");
            }
            else
            {
                    System.out.println("NO");
            }
            
            
            
        }
    }

    static class Solution
    {    
        //Function is to check whether two strings are anagram of each other or not.
        public static boolean isAnagram(String a,String b)
        {
            // Your code here
            Map<Character, Integer> charMap = new HashMap<>();
            for(char c: a.toCharArray()) {
                charMap.put(c, charMap.getOrDefault(c, 0) + 1);
            }
            for(char c: b.toCharArray()) {
                if(!charMap.containsKey(c)) {
                    return false;
                }
                charMap.put(c, charMap.getOrDefault(c, 0) - 1);
                if(charMap.get(c) < 0){
                    return false;
                }
            }
            return true;
        }
    }
}
