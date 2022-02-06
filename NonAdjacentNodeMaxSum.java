// { Driver Code Starts
//Initial Template for Java

//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class NonAdjacentNodeMaxSum {
    

    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    static Node buildTree(String str) {

        if (str.length() == 0 || str.charAt(0) == 'N') {
            return null;
        }

        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue

        Queue<Node> queue = new LinkedList<>();

        queue.add(root);
        // Starting from the second element

        int i = 1;
        while (queue.size() > 0 && i < ip.length) {

            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();

            // Get the current node's value from the string
            String currVal = ip[i];

            // If the left child is not null
            if (!currVal.equals("N")) {

                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }

            // For the right child
            i++;
            if (i >= ip.length)
                break;

            currVal = ip[i];

            // If the right child is not null
            if (!currVal.equals("N")) {

                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }

        return root;
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t > 0) {
            String s = br.readLine(); // Ex: "10 9 8 5 10", "11 1 2"
            Node root = buildTree(s);
            Solution ob = new Solution();
            int ans = ob.getMaxSum(root);
            System.out.println(ans);
            t--;
        }
    }

    static class Solution {
        static Map<Node, Integer> nodeSumMap = new HashMap<>();
        //Function to return the maximum sum of non-adjacent nodes.
        static int getMaxSum(Node root)
        {
            if(nodeSumMap.containsKey(root)){
                return nodeSumMap.get(root);
            }
            // add your code here
            int sum = 0;
            if (root != null) {
                int b = getMaxSum(root.left);
                int c = getMaxSum(root.right);
                int a = root.data;
                if (root.left != null) {
                    a += getMaxSum(root.left.left) + getMaxSum(root.left.right);
                }
                if (root.right != null) {
                    a += getMaxSum(root.right.left) + getMaxSum(root.right.right);
                }
                sum += Math.max(a, b+c);
                nodeSumMap.put(root, sum);
            }
            return sum;
        }
    }
}