package day7;

import java.util.ArrayList;

public class BinaryTree {
	Node root;
	
	public int heightOfNode(Node node) {
		if(node == null) return -1;
		return Math.max(heightOfNode(node.left) + 1, heightOfNode(node.right) + 1);
	}
	
	public boolean isBalanced(Node node) {
		if(node == null) return true;
		
		int leftHeight = heightOfNode(node.left);
		int rightHeight = heightOfNode(node.right);
		
		if(Math.abs(leftHeight - rightHeight) > 1) return false;
		
		return isBalanced(node.left) && isBalanced(node.right);
	}
	
	public boolean isBalance() {
		return isBalanced(root);
	}
	
	public ArrayList<Node> findImbalancedNode(){
		return null;
	}
}
