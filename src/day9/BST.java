package day9;

import java.util.LinkedList;

public class BST {
	Node root;

    public BST(){
        this.root = null;
    }
    
    // Calculates the height of a node in the BST
    // 1/ Time Complexity: O(N) where N is the number of nodes in the subtree rooted at node
    // 2/ Space Complexity: O(h) where h is the height of the tree (due to recursion stack), O(N) in the worst case
    private int height(Node node){
        if(node == null) return -1;
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }
    
    // Rotates a node to the left
    // 1/ Time Complexity: O(1) for the rotation operation
    // 2/ Space Complexity: O(1) for the rotation operation
    private Node rotateLeft(Node node){
        Node alternativeNode = node.right;
        node.right = alternativeNode.left;
        alternativeNode.left = node;
        return alternativeNode;
    }
    
    // Rotates a node to the right
    // 1/ Time Complexity: O(1) for the rotation operation
    // 2/ Space Complexity: O(1) for the rotation operation
    private Node rotateRight(Node node){
        Node alternativeNode = node.left;
        node.left = alternativeNode.right;
        alternativeNode.right = node;
        return alternativeNode;
    }

    // Inserts a value into the BST and balances it if necessary
    // 1/ Time Complexity: O(logN) on average, O(N) in the worst case (unbalanced tree)
    // But since height() is called at each node along the path, the total worst case is O(N^2)
    // 2/ Space Complexity: O(h) where h is the height of the tree (due to recursion stack), O(N) in the worst case
    private Node insertToNode(Node node, int value){
        if(node == null){
            return new Node(value);
        }
        if(value < node.value){
            node.left = insertToNode(node.left, value);
        } else if(value > node.value){
            node.right = insertToNode(node.right, value);
        }

        // balance the tree if necessary
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);
        if(leftHeight - rightHeight > 1){
            // case: Left-Left
            if(value < node.left.value){
                node = rotateRight(node);
            }
            // case: Left-Right
            else {
                node.left = rotateLeft(node.left);
                node = rotateRight(node);
            }
        } else if(rightHeight - leftHeight > 1){
            // case: Right-Right
            if(value > node.right.value){
                node = rotateLeft(node);
            }
            // case: Right-Left
            else {
                node.right = rotateRight(node.right);
                node = rotateLeft(node);
            }
        }

        return node;
    }
    
    public Node insert(int value){
        return insertToNode(root, value);
    }

    public void buildBST(int[] values){
        for(int value : values){
            root = insert(value);
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
