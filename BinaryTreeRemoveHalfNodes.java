//https://www.geeksforgeeks.org/given-a-binary-tree-how-do-you-remove-all-the-half-nodes/
import java.util.Scanner;

public class BinaryTreeRemoveHalfNodes {

	static class Node<T> {
		public Node left;
		public Node right;
		public T data;
		Node(T data) {this.data = data;}
	}

	public static void inOrderTraversal(Node root) {
		if(root != null) {
			inOrderTraversal(root.left);
			System.out.print(root.data);
			System.out.print(" ");
			inOrderTraversal(root.right);
		} else {
			//System.out.print("N ");
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Node<Integer> root = new Node<>(2);
        root.left = new Node<>(7);
        root.right = new Node<>(5);
        root.left.right = new Node<>(6);
        root.left.right.left = new Node<>(1);
        root.left.right.right = new Node<>(11);
        root.right.right = new Node<>(9);
        root.right.right.left = new Node<>(4);
		inOrderTraversal(root);
		System.out.println("\nRemoving half nodes");
		removeHalfNodes(root);
		inOrderTraversal(root);
	}

	public static boolean isLeafNode(Node root) {
		return root.left == null && root.right == null;
	}

	public static Node connectGrandChild(Node root, Node child) {
		if(child != null && (child.left == null || child.right == null)) {
			if(!isLeafNode(child)) {
				if(child.left != null) {child = child.left;}
				else if(child.right != null) {child = child.right;}
			}
		}
		return child;
	}

	public static void removeHalfNodes(Node root) {
		if(root != null) {
			inOrderTraversal(root); System.out.println("");
			if(isLeafNode(root)) {
				return;
			}
			root.left = connectGrandChild(root, root.left);
			removeHalfNodes(root.left);
			root.right = connectGrandChild(root, root.right);
			removeHalfNodes(root.right);
		}
	}
}
