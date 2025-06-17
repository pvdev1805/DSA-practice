package day6;

import java.util.LinkedList;

public class GeneralTree implements TreeOperations {
	Node root;
	
	private Node dfs(Node node, int value) {
		if(node == null) return null;
		
		if(node.value == value) {
			return node;
		}
		
		if(node.children.isEmpty()) return null;
		
		for(Node child: node.children) {
			Node result = dfs(child, value);
			if(result != null) return result;
		}
		
		return null;
	}
	
	private Node bfs(Node node, int value) {
		if(node == null) return null;
		
		LinkedList<Node> q = new LinkedList<>();
		q.addLast(node);
		
		while(!q.isEmpty()) {
			Node curNode = q.getFirst();
			q.removeFirst();
			
			if(curNode.value == value) return curNode;
			if(curNode.children.isEmpty()) {
				continue;
			}
			for(Node childNode: curNode.children) {
				q.addLast(childNode);
			}
		}
		return null;
	}
	
	@Override
	public Node findNode(int value) {
		Node currentNode = root;
		return dfs(currentNode, value);
	}
	
	public Node findNodeBFS(int value) {
		Node currentNode = root;
		return bfs(currentNode, value);
	}
	
	@Override
	public void insert(int parentNodeValue, int targetValue) {
		if(root == null) {
			Node newNode = new Node(targetValue);
			root = newNode;
			return;
		}
		
		Node parentNode = findNode(parentNodeValue);
//		Node parentNode = findNodeBFS(parentNodeValue);
		
		if(parentNode == null) {
			throw new IllegalArgumentException("Error: Insertion failed !\nFailed to find a parent node having a value: " + parentNodeValue);
		}
		
		Node newNode = new Node(targetValue);
		parentNode.children.add(newNode);
	}
}
