package day6;

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
	
	@Override
	public Node findNode(int value) {
		if(root == null) return null;
		Node currentNode = root;
		return dfs(currentNode, value);
	}
}
