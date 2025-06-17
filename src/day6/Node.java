package day6;

import java.util.ArrayList;

public class Node {
	Integer value;
	ArrayList<Node> children;
	
	Node() {
		children = new ArrayList<Node>();
	}
	
	Node(int value){
		this.value = value;
		this.children = new ArrayList<Node>();
	}
}
