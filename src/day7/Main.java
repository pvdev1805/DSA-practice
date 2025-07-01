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
		System.out.println();
		
		// Balance Tree
		BinaryTree tree2 = new BinaryTree();
        tree2.insertNode(0, 'L', 3);
        tree2.insertNode(3, 'L', 2);
        tree2.insertNode(2, 'L', 1);
        tree2.postOrderTraversal(tree2.root);

        //    30
        //   /
        //  20
        //  /
        // 10

        // Left-Left --> Right Rotate

        System.out.println();
        tree2.balanceTree();
        tree2.postOrderTraversal(tree2.root);
        //    20
        //   /  \
        // 10   30
        System.out.println();

        BinaryTree tree3 = new BinaryTree();
        tree3.insertNode(0, 'L', 1);
        tree3.insertNode(1, 'R', 2);
        tree3.insertNode(2, 'R', 3);
        tree3.insertNode(2, 'L', 4);
        tree3.postOrderTraversal(tree3.root);

        //    1
        //     \
        //      2
        //     / \
        //    4   3
        System.out.println();
        tree3.balanceTree();
        tree3.postOrderTraversal(tree3.root);
        //    2
        //   /  \
        //  1    3
        // /
        // 4
        System.out.println();
        
        BinaryTree tree4 = new BinaryTree();
        tree4.insertNode(0, 'L', 3);
        tree4.insertNode(3, 'L', 1);
        tree4.insertNode(1, 'R', 2);
        tree4.postOrderTraversal(tree4.root);
        //    3
        //   /
        //  1
        //   \
        //    2
        System.out.println();
        tree4.balanceTree();
        tree4.postOrderTraversal(tree4.root);
        //    2
        //   / \
        //  1   3
        System.out.println();

        BinaryTree tree5 = new BinaryTree();
        tree5.insertNode(0, 'L', 1);
        tree5.insertNode(1, 'R', 3);
        tree5.insertNode(3, 'L', 2);
        tree5.postOrderTraversal(tree5.root);
        //    1
        //     \
        //      3
        //     /
        //    2
        System.out.println();
        tree5.balanceTree();
        tree5.postOrderTraversal(tree5.root);
        //    2
        //   / \
        //  1   3
        System.out.println();

        BinaryTree tree6 = new BinaryTree();
        tree6.insertNode(0, 'L', 5);
        tree6.insertNode(5, 'L', 3);
        tree6.insertNode(3, 'L', 1);
        tree6.insertNode(1, 'R', 8);
        tree6.insertNode(5, 'R', 7);
        tree6.insertNode(7, 'R', 9);
        tree6.insertNode(9, 'R', 10);
        tree6.postOrderTraversal(tree6.root);
        //     5
        //    / \
        //   3   7
        //  /     \
        // 1       9
        //  \       \
        //   8      10
        System.out.println();
        tree6.balanceTree();
        tree6.postOrderTraversal(tree6.root);
        //      5
        //    /   \
        //   8     9
        //  / \   / \
        // 1   3 7  10

        System.out.println();
	}
}
