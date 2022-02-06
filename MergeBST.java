/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
import java.math.*;

public class MergeBST {
    // { Driver Code Starts
//Initial Template for Java

    static class Node  
    { 
        int data; 
        Node left, right; 
    
        public Node(int d)  
        { 
            data = d; 
            left = right = null; 
        } 
    }

    static class GFG
    {
        static Node buildTree(String str)
        {
            // Corner Case
            if(str.length() == 0 || str.equals('N'))
                return null;
            String[] s = str.split(" ");
            
            Node root = new Node(Integer.parseInt(s[0]));
            Queue <Node> q = new LinkedList<Node>();
            q.add(root);
            
            // Starting from the second element
            int i = 1;
            while(!q.isEmpty() && i < s.length)
            {
                // Get and remove the front of the queue
                Node currNode = q.remove();
            
                // Get the curr node's value from the string
                String currVal = s[i];
            
                // If the left child is not null
                if(!currVal.equals("N")) 
                {
            
                    // Create the left child for the curr node
                    currNode.left = new Node(Integer.parseInt(currVal));
            
                    // Push it to the queue
                    q.add(currNode.left);
                }
            
                // For the right child
                i++;
                if(i >= s.length)
                    break;
                currVal = s[i];
            
                // If the right child is not null
                if(!currVal.equals("N")) 
                {
            
                    // Create the right child for the curr node
                    currNode.right = new Node(Integer.parseInt(currVal));
            
                    // Push it to the queue
                    q.add(currNode.right);
                }
                
                i++;
            }
        
            return root;
        }
        
        public static void main(String args[]) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int t = Integer.parseInt(br.readLine().trim());
            while(t>0)
            {
                String s = br.readLine();
                Node root1 = buildTree(s);
                
                s = br.readLine();
                Node root2 = buildTree(s);
                
                Solution T = new Solution();
                List<Integer> ans = T.merge(root1,root2);
                for(int i=0;i<ans.size();i++)
                    System.out.print(ans.get(i) + " ");
                System.out.println();
                
                t--;
            }
        }
    }
    // } Driver Code Ends


    //User function Template for Java


    /*
    class Node  
    { 
        int data; 
        Node left, right; 
    
        public Node(int d)  
        { 
            data = d; 
            left = right = null; 
        } 
    }
        
    */
    static class Solution
    {
        
        private void inOrder(Node root, List<Integer> arrList) {
            if(root != null) {
                inOrder(root.left, arrList);
                arrList.add(root.data);
                inOrder(root.right, arrList);
            }
        }
        
        private void mergeNodes(Node root1, Node root2, List<Integer> arrList) {
            
            if(root1 == null && root2 == null) {
                return;
            }
            if(root1 == null) {
                inOrder(root2, arrList);
                return; 
            }
            if(root2 == null) {
                inOrder(root1, arrList);
                return;
            }
            Node parent1 = null;
            Node temp1 = root1;
            Node parent2 = null;
            Node temp2 = root2;
            // Find parent and the left most child
            while(temp1.left != null) {
                parent1 = temp1;
                temp1 = temp1.left;
            }
            while(temp2.left != null) {
                parent2 = temp2;
                temp2 = temp2.left;
            }
            
            // Now compare left most children
            if(temp1.data <= temp2.data) {
                arrList.add(temp1.data);
                if(parent1 == null) {
                    // temp1 is the root element. Merge with right of temp1
                    mergeNodes(root1.right, root2, arrList);
                } else {
                    parent1.left = temp1.right; // Delete the left node of parent as it is processed
                    mergeNodes(root1, root2, arrList);    
                }
            } else {
                arrList.add(temp2.data);
                if(parent2 == null) {
                    mergeNodes(root1, root2.right, arrList);
                } else {
                    parent2.left = temp2.right; // Delete the left node of parent as it is processed
                    mergeNodes(root1, root2, arrList);
                }
            }
        }
        
        //Function to return a list of integers denoting the node 
        //values of both the BST in a sorted order.
        public List<Integer> merge(Node root1,Node root2)
        {
            // Write your code here
            List<Integer> arrList =  new ArrayList<>();
            mergeNodes(root1, root2, arrList);
            return arrList;
        }

        public List<Integer> morrisTraversalMerge(Node root1, Node root2) {
            List<Integer> arrList = new ArrayList<>();
            while(root1 != null || root2 != null) {
                // Find leftmost root1
                while(root1 != null) {
                    if(root1.left != null) {
                        Node left = root1.left;
                        // Move to rightmost of the left node
                        while(left.right != null) {
                            left = left.right;
                        }
                        // Assign root1 to right of rightmost and make left of root1 null
                        left.right = root1;
                        left = root1.left;
                        // Make left of root null now, since original root is no longer root
                        root1.left = null;
                        root1 = left;
                    } else {
                        break;
                    }
                }
                // Find leftmost root2
                while(root2 != null) {
                    if(root2.left != null) {
                        Node left = root2.left;
                        // Move to rightmost of left of root2
                        while(left.right != null) {
                            left = left.right;
                        }
                        // Assign root2 to right of the rightmost node of left of root2
                        left.right = root2;
                        left = root2.left;
                        // Make left of root null now, since original root is no longer root 
                        root2.left = null;
                        root2 = left;
                    } else {
                        break;
                    }
                }
                if(root1 != null && root2 != null) {
                    if(root1.data <= root2.data){
                        arrList.add(root1.data);
                        root1 = root1.right;
                    } else {
                        arrList.add(root2.data);
                        root2 = root2.right;
                    }
                } else if (root1 != null) {
                    arrList.add(root1.data);
                    root1 = root1.right;
                } else {
                    arrList.add(root2.data);
                    root2 = root2.right;
                }
            }
            return arrList;
        }
    }

}
