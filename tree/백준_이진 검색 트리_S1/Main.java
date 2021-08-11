package s1_5639_이진검색트리;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import javax.swing.RootPaneContainer;

public class Main {
	
	static Node root;
	
	static class Node {
		Node left;
		Node right;
		int value;
		
		public Node(int value) {
			this.value = value;
		}
		
		public static void insertNode(int value) {
			Node newNode = new Node(value);
			if (root == null) {
				root = newNode;
				return;
			}
			
			Node currentNode = root;
			while(true) {
				if (currentNode.value > value) {
					if (currentNode.left == null) {
						currentNode.left = newNode;
						return;
					}
					currentNode = currentNode.left;
				}
				else {
					if (currentNode.right == null) {
						currentNode.right = newNode;
						return;
					}
					currentNode = currentNode.right;
				}
			}
		}
		
		public static void postOrder(Node current) {
			if (current == null)
				return;

			postOrder(current.left);
			postOrder(current.right);
			System.out.println(current.value);
			
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		String str;
		while((str = br.readLine()) != null)
			Node.insertNode(Integer.parseInt(str));
		
		Node.postOrder(root);

	}
}

