package day6;

import java.util.LinkedList;

public class GeneralTree implements TreeOperations {
	Node root;
	
	private Node dfs(Node node, int value) {
		if(node == null) return null;
		
		for(Node child: node.children) {
			Node found = dfs(child, value);
			if(found != null) return found;
		}
		
		System.out.println("Node Address = " + node);
		System.out.println("Node value = " + node.value);
		System.out.println();
		if(node.value == value) return node;
		
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
		System.out.println("Round :");
		return dfs(root, value);
	}
	
	public Node findNodeBFS(int value) {
		Node currentNode = root;
		return bfs(currentNode, value);
	}
	
	@Override
	public void insert(int parentNodeValue, int targetValue) {
		if(root == null) {
			root = new Node(targetValue);
			return;
		}
		
		Node parentNode = findNode(parentNodeValue);
//		Node parentNode = findNodeBFS(parentNodeValue);
		
		Node newNode = new Node(targetValue);
		parentNode.children.add(newNode);
	}
}
