package day6;

import java.util.LinkedList;

public class GeneralTree implements TreeOperations {
	Node root;
	
	// DFS - Recursion --> if time is preferred
	// Time Complexity: O(N) --> Tree has N nodes
	// Space Complexity: O(3 * N) --> O(N)
	private Node dfs(Node node, int value) {
		if(node == null) return null;
		
		for(Node child: node.children) {
			Node found = dfs(child, value);
			if(found != null) return found;
		}
		
		if(node.value == value) return node;
		
		return null;
	}
	
	// DFS - Loop --> If space is preferred
	// Time Complexity: O(N^2 + 2*N) --> O(N^2)
	// Space Complexity: O(N)
	private Node dfsLoop(Node node, int value) {
		LinkedList<Node> listChildren = new LinkedList<>();
		LinkedList<Node> listSeenChildren = new LinkedList<>();
		
		listChildren.add(node);
		
		while(!listChildren.isEmpty()) {
			Node currentNode = listChildren.getLast();
			
			if(!listSeenChildren.containsAll(currentNode.children)) {
				for(int i = currentNode.children.size() - 1; i >= 0; i--) {
					listChildren.add(currentNode.children.get(i));
				}
			} else {
				if(currentNode.value == value) {
					return currentNode;
				} else {
					listSeenChildren.add(listChildren.pollLast());
				}
			}
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
		return dfs(root, value);
	}
	
	public Node findNodeDFSLoop(int value) {
		return dfsLoop(root, value);
	}
	
	public Node findNodeBFS(int value) {
		return bfs(root, value);
	}
	
	@Override
	public void insert(int parentNodeValue, int targetValue) {
		if(root == null) {
			root = new Node(targetValue);
			return;
		}
		
//		Node parentNode = findNode(parentNodeValue);
		Node parentNode = findNodeDFSLoop(parentNodeValue);
//		Node parentNode = findNodeBFS(parentNodeValue);
		
		Node newNode = new Node(targetValue);
		parentNode.children.add(newNode);
	}
	
	@Override
	public void postOrderTraversal(Node node) {
		if(node == null) return;
		for(Node child: node.children) {
			postOrderTraversal(child);
		}
		System.out.print(node.value + "  ");
	}
}
