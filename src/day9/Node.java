package day9;

public class Node {
	Integer value;
	Node left;
	Node right;
	
	Node(){
		left = null;
		right = null;
	}
	
	Node(int value){
		this.value = value;
		this.left = null;
		this.right = null;
	}
}
