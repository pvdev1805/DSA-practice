package day7;

import java.util.ArrayList;
import java.util.LinkedList;

public class BinaryTree {
	Node root;
	
	// 1. dfs
	// Time Complexity: O(N) -- Visits each node once in the worst case
	// Space Complexity: O(N) -- (recursion stack, the worst case: height = N)
	private Node dfs(Node node, int value) {
		if(node == null) return null;
		
		Node leftChild = dfs(node.left, value);
		if(leftChild != null) return leftChild;
		
		Node rightChild = dfs(node.right, value);
		if(rightChild != null) return rightChild;
		
		if(node.value == value) return node;
		
		return null;
	}
	
	// 2. bfs
	// Time Complexity: O(N) -- each node is enqueued/dequeued once
	// Space Complexity: O(N) -- (queue holds up to w nodes, with w = max width of tree, in the worst case, w = N)
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
	
	// 3. findNode
	// Time Complexity: O(N) -- call DFS or BFS
	// Space Complexity: O(N) -- call DFS or BFS
	public Node findNode(int value) {
//		 return dfs(root, value);
		return bfs(root, value);
	}
	
	// 4. insertNode
	// Time Complexity: O(N) -- find parent Node
	// Space Complexity: O(N) -- call DFS or BFS 
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
	
	// 5. Traversal
	// 5.1/ PreOrderTraversal
	// Time Complexity: O(N) -- visit each node once
	// Space Complexity: O(N) -- recursion stack
	public void preOrderTraversal(Node node) {
		if(node == null) return;
		System.out.println(node.value + " ");
		preOrderTraversal(node.left);
		preOrderTraversal(node.right);
	}
	
	// 5.2/ InOrderTraversal
	// Time Complexity: O(N) -- visit each node once
	// Space Complexity: O(N) -- recursion stack
	public void inOrderTraversal(Node node){
		if(node == null) return;
		inOrderTraversal(node.left);
		System.out.println(node.value + " ");
		inOrderTraversal(node.right);
	}
	
	// 5.3/ PostOrderTraversal
	// Time Complexity: O(N) -- visit each node once
	// Space Complexity: O(N) -- recursion stack
	public void postOrderTraversal(Node node) {
		if(node == null) return;
		postOrderTraversal(node.left);
		postOrderTraversal(node.right);
		System.out.print(node.value + " ");
	}
	
	// 5.4/ LevelOrderTRaversal
	// Time Complexity: O(N)
	// Space Complexity: O(N)
	public void levelOrderTraversal(Node node) {
		if(node == null) return;

        LinkedList<Node> q = new LinkedList<>();
        q.addLast(node);

        while(!q.isEmpty()) {
            Node currentNode = q.getFirst();
            q.removeFirst();
            System.out.print(currentNode.value + " ");
            if(currentNode.left != null) q.addLast(currentNode.left);
            if(currentNode.right != null) q.addLast(currentNode.right);
        }
	}
	// End - Traversals
	
	// 
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
	// checkBalance2
	// Time Complexity: O(N)
	// Space Complexity: O(N + k) -- k: number of imbalanced nodes
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
	
	// findImbalancedNodes3
	// Time Complexity: O(N)
	// Space Complexity: O(N + k)
	public ArrayList<Node> findImbalancedNodes3(){
		ArrayList<Node> res = new ArrayList<>();
		checkBalance2(root, res);
		return res;
	}
	
	// isBalance2
	// Time Complexity: O(N)
	// Space Complexity: O(N + k)
	public boolean isBalance2() {
		return findImbalancedNodes3().isEmpty();
	}
	
	// Rotations
	// 1/ leftRotate
	// Time Complexity: O(1)
	// Space Complexity: O(1)
	public Node leftRotate(Node node) {
        Node targetNode = node.right;
        node.right = targetNode.left;
        targetNode.left = node;
        return targetNode;
    }
	
	// 2/ rightRotate
	// Time Complexity: O(1)
	// Space Complexity: O(1)
    public Node rightRotate(Node node) {
        Node targetNode = node.left;
        node.left = targetNode.right;
        targetNode.right = node;
        return targetNode;
    }
	
	// Balance
    // 1/ height
    // Time Complexity: O(N)
 	// Space Complexity: O(h) --> the worst case: O(N)
    public int height(Node node){
        if(node == null) return 0;
        return Math.max(height(node.left), height(node.right)) + 1;
    }
    
    // 2/ balance
    // Time Complexity: O(4*N) --> O(N)
  	// Space Complexity: O(h) --> the worst case: O(N)
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
    
    // 3/ checkBalanceAndBalance
    // Time Complexity: O(N^2) (calls balance at each node, which calls height O(n) times)
    // Space Complexity: O(h) --> the worst case: O(N)
    public Node checkBalanceAndBalance(Node node){
        if(node == null) return null;
        node.left = checkBalanceAndBalance(node.left);
        node.right = checkBalanceAndBalance(node.right);
        return balance(node);
    }
    
    // 4/ balanceTree
    // Time Complexity: O(N^2) (calls checkBalanceAndBalance on root)
    // Space Complexity: O(h) --> the worst case: O(N)
    public void balanceTree(){
        root = checkBalanceAndBalance(root);
    }
}
