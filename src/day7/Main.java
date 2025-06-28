package day7;

import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		
		BinaryTree tree = new BinaryTree();
		tree.insertNode(0,'L', 10);
		tree.insertNode(10, 'L', 5);
		tree.insertNode(5, 'R', 7);
		tree.insertNode(10, 'R', 15);
		tree.insertNode(5, 'L', 2);
		
		tree.postOrderTraversal(tree.root);
		System.out.println();
		System.out.println("Is tree imbalanced: " + tree.isBalance());
		
		
		
		BinaryTree tree1 = new BinaryTree();
		tree1.insertNode(0, 'L', 10);
		tree1.insertNode(10, 'R', 15);
		tree1.insertNode(15, 'R', 20);
		tree1.insertNode(20, 'R', 25);
		tree1.insertNode(10, 'L', 5);
		tree1.insertNode(5, 'L', 2);
		tree1.insertNode(2, 'L', 1);
		
		tree1.postOrderTraversal(tree1.root);
		System.out.println();
		System.out.println("Is tree imbalanced: " + tree1.isBalance());
		
		ArrayList<Node> imbalancedNodes = tree1.findImbalancedNodes();
		for(Node node: imbalancedNodes) {
			System.out.print(node.value + " ");
		}
		System.out.println();
		ArrayList<Node> imbalancedNodes2 = tree1.findImbalancedNodes2();
		for(Node node: imbalancedNodes2) {
			System.out.print(node.value + " ");
		}
	}
}
