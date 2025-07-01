package day7;

import java.util.ArrayList;
import java.util.LinkedList;

public class BinaryTree {
	Node root;
	
	private Node dfs(Node node, int value) {
		if(node == null) return null;
		
		Node leftChild = dfs(node.left, value);
		if(leftChild != null) return leftChild;
		
		Node rightChild = dfs(node.right, value);
		if(rightChild != null) return rightChild;
		
		if(node.value == value) return node;
		
		return null;
	}
	
	private Node bfs(Node node, int value) {
		if(node == null) return null;
		
		LinkedList<Node> q = new LinkedList<>();
		q.addLast(node);
		
		while(!q.isEmpty()) {
			Node currentNode = q.getFirst();
			q.removeFirst();
			
			if(currentNode.value == value) return currentNode;
			if(currentNode.left == null && currentNode.right == null) continue;
			if(currentNode.left != null) q.addLast(currentNode.left);
			if(currentNode.right != null) q.addLast(currentNode.right);
		}
		return null;
	}
	
	public Node findNode(int value) {
//		 return dfs(root, value);
		return bfs(root, value);
	}
	
	public void insertNode(int parentNodeValue, char position, int targetValue) {
		if(root == null) {
			root = new Node(targetValue);
			return;
		}
		
		Node parentNode = findNode(parentNodeValue);
		Node newNode = new Node(targetValue);
		if(position == 'L') {
			parentNode.left = newNode;
		} else if(position == 'R') {
			parentNode.right = newNode;
		}
	}
	
	public void postOrderTraversal(Node node) {
		if(node == null) return;
		postOrderTraversal(node.left);
		postOrderTraversal(node.right);
		System.out.print(node.value + " ");
	}
	
	// Assume height of node root = 0
	public int heightOfNode(Node node) {
		if(node == null) return -1;
		return Math.max(heightOfNode(node.left) + 1, heightOfNode(node.right) + 1);
	}
	
	// Assume height of node root = 1
	public int heightOfNode2(Node node) {
		if(node == null) return 0; // Want root to be 0 --> return -1;
		int leftHeight = heightOfNode2(node.left);
		int rightHeight = heightOfNode2(node.right);
		return Math.max(leftHeight, rightHeight) + 1;
	}
	
	public int heightOfNodeBFS(Node node) {
		if(node == null) return -1;
		
		LinkedList<Node> q = new LinkedList<>();
		q.addLast(node);
		int height = -1;
		
		while(!q.isEmpty()) {
			int size = q.size();
			height++;
			
			for(int i = 0; i < size; i++) {
				Node currentNode = q.getFirst();
				q.removeFirst();
				
				if(currentNode.left != null) q.addLast(currentNode.left);
				if(currentNode.right != null) q.addLast(currentNode.right);
			}
		}
		
		return height;
	}
	
	public boolean isBalancedFromNode(Node node) {
		if(node == null) return true;
		
		int leftHeight = heightOfNode(node.left);
		int rightHeight = heightOfNode(node.right);
		
		if(Math.abs(leftHeight - rightHeight) > 1) return false;
		
		return isBalancedFromNode(node.left) && isBalancedFromNode(node.right);
	}
	
	public boolean isBalance() {
		return isBalancedFromNode(root);
	}
	
	// Slow
	public boolean checkBalancedNode(Node node, ArrayList<Node> nodes) {
		if(node == null) return true;
		
		int leftHeight = heightOfNode(node.left);
		int rightHeight = heightOfNode(node.right);
		
		boolean leftBalanced = checkBalancedNode(node.left, nodes);
		boolean rightBalanced = checkBalancedNode(node.right, nodes);
		
		int heightDiff = Math.abs(leftHeight - rightHeight);
		if(heightDiff > 1) {
			nodes.add(node);
		}
		
		return leftBalanced && rightBalanced && heightDiff <= 1;
	}
	
	// Slow
	public ArrayList<Node> findImbalancedNodes(){
		ArrayList<Node> res = new ArrayList<>();
		checkBalancedNode(root, res);
		return res;
	}
	
	// Optimize
	public int checkAndCollect(Node node, ArrayList<Node> nodes) {
		if(node == null) return 0;
		
		int leftHeight = checkAndCollect(node.left, nodes);
		int rightHeight = checkAndCollect(node.right, nodes);
		
		int heightDiff = Math.abs(leftHeight - rightHeight);
		if(heightDiff > 1) {
			nodes.add(node);
		}
		
		return heightDiff + 1;
	}
	
	// Optimize
	public ArrayList<Node> findImbalancedNodes2(){
		ArrayList<Node> res = new ArrayList<>();
		checkAndCollect(root, res);
		return res;
	}
	
	// Additional Solutions
	public int checkBalance2(Node node, ArrayList<Node> imbalancedNodes) {
		if(node == null) return 0;
		
		int leftHeight = checkBalance2(node.left, imbalancedNodes);
		int rightHeight = checkBalance2(node.right, imbalancedNodes);
		
		if(Math.abs(leftHeight - rightHeight) > 1) {
			imbalancedNodes.add(node);
		}
		
		// rebalanced
		
		return Math.max(leftHeight, rightHeight) + 1;
	}
	
	public ArrayList<Node> findImbalancedNodes3(){
		ArrayList<Node> res = new ArrayList<>();
		checkBalance2(root, res);
		return res;
	}
	
	public boolean isBalance2() {
		return findImbalancedNodes3().isEmpty();
	}
	
	// Rotations
	public Node leftRotate(Node node) {
        Node targetNode = node.right;
        node.right = targetNode.left;
        targetNode.left = node;
        return targetNode;
    }

    public Node rightRotate(Node node) {
        Node targetNode = node.left;
        node.left = targetNode.right;
        targetNode.right = node;
        return targetNode;
    }
	
	// Balance
    public int height(Node node){
        if(node == null) return 0;
        return Math.max(height(node.left), height(node.right)) + 1;
    }

    public Node balance(Node node){
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);

        if(leftHeight - rightHeight > 1){
            // Case 1: Left-Left
            if(height(node.left.left) >= height(node.left.right)){
                node = rightRotate(node);
            }
            // Case 2: Left-Right
            else {
                node.left = leftRotate(node.left);
                node = rightRotate(node);
            }
        } else if (rightHeight - leftHeight > 1){
            // Case 1: Right-Right
            if(height(node.right.right) >= height(node.right.left)){
                node = leftRotate(node);
            }
            // Case 2: Right-left
            else {
                node.right = rightRotate(node.right);
                node = leftRotate(node);
            }
        }
        return node;
    }

    public Node checkBalanceAndBalance(Node node){
        if(node == null) return null;
        node.left = checkBalanceAndBalance(node.left);
        node.right = checkBalanceAndBalance(node.right);
        return balance(node);
    }

    public void balanceTree(){
        root = checkBalanceAndBalance(root);
    }
}
