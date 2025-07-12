package day9;

public class Node {
	Integer value;
	Node left;
	Node right;
	int leftHeight;
    int rightHeight;

    Node() {
        this.left = null;
        this.right = null;
        this.leftHeight = -1;
        this.rightHeight = -1;
    }

    Node(int value){
        this.value = value;
        this.left = null;
        this.right = null;
        this.leftHeight = -1;
        this.rightHeight = -1;
    }
}
