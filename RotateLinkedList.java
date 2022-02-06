// { Driver Code Starts
import java.util.*;
public class RotateLinkedList {
    static class Node {
        int data;
        Node next;
        Node(int d) {
            data = d;
            next = null;
        }
    } 
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while (t-- > 0) {
            int n = sc.nextInt();
            
            int a = sc.nextInt();
            Node head = new Node(a);
            Node tail = head;
            
            for (int i=0; i<n-1; i++)
            {
                a = sc.nextInt();
                tail.next = new Node(a);
                tail = tail.next;
            }
            
            int k = sc.nextInt();
            
            Solution ob = new Solution();
            head = ob.rotate(head,k);
            printList(head);
        }
    }
    
    public static void printList(Node n) {
        while (n != null) {
            System.out.print(n.data + " ");
            n = n.next;
        }
        System.out.println();
    }
    
    static class Solution{
        //Function to rotate a linked list.
        public Node rotate(Node head, int k) {
            // add code here
            Node curr = head;
            Node lastNode = head;
            while(curr != null && k > 0) {
                curr = curr.next;
                k--;
                if(k == 1) {
                    lastNode = curr;
                }
            }
            lastNode.next = null;
            // curr has the new head now.
            Node oldHead = head;
            head = curr;
            if(curr != null) {
                while(curr.next != null) {
                    curr = curr.next;
                }
                curr.next = oldHead;
                return head;
            } else {
                if(k > 0) {
                    return rotate(head, k);
                }
                return oldHead;
            }
            
        }
    }
}