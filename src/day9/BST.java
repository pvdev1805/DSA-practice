package day9;

import java.util.LinkedList;

public class BST {
	Node root;

    public BST(){
        this.root = null;
    }
    
    // Calculates the height of a node
    // 1/ Time Complexity: O(1) for the height calculation
    // 2/ Space Complexity: O(1) for the height calculation
    private int getHeight(Node node){
        if(node == null){
            return -1; // Height of an empty tree is -1
        }
        return Math.max(node.leftHeight, node.rightHeight) + 1;
    }

    // Updates the height of a node based on its children
    // 1/ Time Complexity: O(1) for the height update
    // 2/ Space Complexity: O(1) for the height update
    private void updateHeight(Node node){
        if(node == null) return;
        node.leftHeight = (node.left != null) ? getHeight(node.left) : -1;
        node.rightHeight = (node.right != null) ? getHeight(node.right) : -1;
    }

    // Rotates a node to the left
    // 1/ Time Complexity: O(1) for the rotation operation
    // 2/ Space Complexity: O(1) for the rotation operation
    private Node rotateLeft(Node node){
        Node alternativeNode = node.right;
        node.right = alternativeNode.left;
        alternativeNode.left = node;

        updateHeight(node);
        updateHeight(alternativeNode);

        return alternativeNode;
    }

    // Rotates a node to the right
    // 1/ Time Complexity: O(1) for the rotation operation
    // 2/ Space Complexity: O(1) for the rotation operation
    private Node rotateRight(Node node){
        Node alternativeNode = node.left;
        node.left = alternativeNode.right;
        alternativeNode.right = node;

        updateHeight(node);
        updateHeight(alternativeNode);

        return alternativeNode;
    }

    // Inserts a new value into the BST
    // 1/ Time Complexity: O(log n) on average
    // 2/ Space Complexity: O(log n) on average for the recursion stack
    private Node insert(Node node, int value) {
        if (node == null) {
            return new Node(value);
        }
        if (value < node.value) {
            node.left = insert(node.left, value);
        } else if (value > node.value) {
            node.right = insert(node.right, value);
        }
        updateHeight(node);
        return balance(node);
    }

    // Balance
    // 1/ Time Complexity: O(1) for the balance operation
    // 2/ Space Complexity: O(1) for the balance operation
    private Node balance(Node node){
        if (node == null) {
            return null;
        }

        // Check the balance factor
        int balanceFactor = node.leftHeight - node.rightHeight;

        if(balanceFactor > 1){
            // Left heavy
            if(node.left != null && node.left.rightHeight > node.left.leftHeight){
                // case: Left-Right
                node.left = rotateLeft(node.left);
            }
            // case: Left-Left
            node = rotateRight(node);
        } else if(balanceFactor < -1){
            // Right heavy
            if(node.right != null && node.right.leftHeight > node.right.rightHeight){
                // case: Right-Left
                node.right = rotateRight(node.right);
            }
            // case: Right-Right
            node = rotateLeft(node);
        }

        return node;
    }
    
    // Inserts a new node with the given value into the BST
    // 1/ Time Complexity: O(logN) on average
    // 2/ Space Complexity: O(logN) on average for the recursion stack
    public void insertNode(int value) {
        if (root == null) {
            root = new Node(value);
        } else {
            root = insert(root, value);
        }
        updateHeight(root);
    }
    
    // Builds the BST from an array of integers
    // 1/ Time Complexity: O(N*logN) where n is the number of elements in the array
    // 2/ Space Complexity: O(N) for the nums array and O(logN) for the recursion stack --> O(N) overall
    public void buildBST(int[] nums) {
        for (int num : nums) {
            insertNode(num);
        }
    }
    
    // Performs level order traversal of the BST
    // 1/ Time Complexity: O(N) where N is the number of nodes in the tree
    // 2/ Space Complexity: O(N) for the queue used in level order traversal
    public void levelOrderTraversal(){
        if(root == null) return;
        LinkedList<Node> q = new LinkedList<>();
        q.addLast(root);

        while(!q.isEmpty()){
            Node currentNode = q.getFirst();
            q.removeFirst();
            System.out.print(currentNode.value + " ");
            if(currentNode.left != null){
                q.addLast(currentNode.left);
            }
            if(currentNode.right != null){
                q.addLast(currentNode.right);
            }
        }
    }
    
    // Prints the BST in level order traversal
    // 1/ Time Complexity: O(N) where N is the number of nodes in the tree
    // 2/ Space Complexity: O(N) for the queue used in level order traversal
    public void printBST() {
        if (root == null) {
            System.out.println("Tree is empty.");
            return;
        }
        System.out.print("Level Order Traversal: ");
        levelOrderTraversal();
        System.out.println();
    }
}
